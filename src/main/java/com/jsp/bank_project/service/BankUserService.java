package com.jsp.bank_project.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.bank_project.Entity.BankUser;
import com.jsp.bank_project.Entity.ListOfBanksBranches;
import com.jsp.bank_project.dao.BankBranchDao;
import com.jsp.bank_project.dao.BankUserDao;
import com.jsp.bank_project.dto.BankUserDto;
import com.jsp.bank_project.exception.AccountIsNotFoundBasedOnNameException;
import com.jsp.bank_project.exception.AdhharNumberIsAlreadyPresentException;
import com.jsp.bank_project.exception.BankUserNotFoundBasedOnNameAndAccountNumber;
import com.jsp.bank_project.exception.BranchIdNotFoundException;
import com.jsp.bank_project.exception.PhoneNumberIsAlreadyPresentException;
import com.jsp.bank_project.repository.BankUserRepo;
import com.jsp.bank_project.responseStructure.ResponseStructiure;

@Service
public class BankUserService {
    @Autowired
    private BankUserDao userDao;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BankBranchDao branchDao;
    @Autowired
    private BankUserRepo userRepo;
	public ResponseEntity<ResponseStructiure<BankUser>> saveUser(BankUserDto bankUserDto, int id) {
			ListOfBanksBranches branch = branchDao.getBranchById(id);
			if (branch!=null)
			{
			    BankUser user=userRepo.findByPhoneNumber(bankUserDto.getPhoneNumber());
                if (user==null)
                {
            	    BankUser user1=userRepo.findByAdhharNumber(bankUserDto.getAdhharNumber());
            	    if (user1==null)
            	    {
            	    	BankUser bankUser=this.modelMapper.map(bankUserDto, BankUser.class);
        				bankUser.setListOfBanksBranches(branch);
        				BankUser dbBankUser=userDao.saveUser(bankUser);
        				if (branch.getBankUsers().isEmpty())
        				{
        					List<BankUser> listOfbankUses=new ArrayList<BankUser>();
        					listOfbankUses.add(bankUser);
        					branch.setBankUsers(listOfbankUses);
        					branchDao.saveBranch(branch);
        				}
        				else
        				{
        					List<BankUser> listOfBankUsers=branch.getBankUsers();
        					listOfBankUsers.add(bankUser);
        					branch.setBankUsers(listOfBankUsers);
        					branchDao.saveBranch(branch);
        				}
        				ResponseStructiure<BankUser> responseStructiure=new ResponseStructiure<BankUser>();
        				responseStructiure.setMessage("User is saved succsfully");
        				responseStructiure.setObject(dbBankUser);
        				responseStructiure.setStatus(HttpStatus.FOUND.value());
        				return new ResponseEntity<ResponseStructiure<BankUser>>(responseStructiure,HttpStatus.FOUND);
            	    }
            	    throw new AdhharNumberIsAlreadyPresentException("failed to add user");
                }
                throw new PhoneNumberIsAlreadyPresentException("failed to add user");   
			}
			throw new BranchIdNotFoundException("Branch is Not Present to Add The User");
	}
	public ResponseEntity<ResponseStructiure<BankUser>> getUserByNameAndAccountNumber(String name, long accountNumber, String password) {
		BankUser dbBankUser=userDao.getUserByNameAndPhnoneNumber(name,accountNumber,password);
		if (dbBankUser!=null)
		{
		ResponseStructiure<BankUser> responseStructiure=new ResponseStructiure<BankUser>();
		responseStructiure.setMessage("User is fetched succsfully");
		responseStructiure.setObject(dbBankUser);
		responseStructiure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructiure<BankUser>>(responseStructiure,HttpStatus.FOUND);
		}
		throw new BankUserNotFoundBasedOnNameAndAccountNumber("failed to fetch the bank user");
	}
	public ResponseEntity<ResponseStructiure<BankUser>> deleteUserByNameAndAccountNumber(String name, long accountNumber, String password) {
		BankUser dbBankUser=userDao.getUserByNameAndPhnoneNumber(name,accountNumber,password);
		if (dbBankUser!=null)
		{
			ListOfBanksBranches branch=dbBankUser.getListOfBanksBranches();
//			ListOfBanksBranches dbListOfBanksBranches=branchDao.getBranchById(branch.getId());
//			List<BankUser> list=dbListOfBanksBranches.getBankUsers();
//			for (BankUser user:list)
//			{
//				if (user.equals(dbBankUser.getListOfBanksBranches()))
//				{
//					list.remove(user);
//				}
//			}
//			dbListOfBanksBranches.setBankUsers(list);
//			branchDao.saveBranch(dbListOfBanksBranches);
			BankUser dbBankUser2=userDao.deleteUser(dbBankUser);
			ResponseStructiure<BankUser> responseStructiure=new ResponseStructiure<BankUser>();
			responseStructiure.setMessage("User is deleted succsfully");
			responseStructiure.setObject(dbBankUser2);
			responseStructiure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructiure<BankUser>>(responseStructiure,HttpStatus.OK);
		}
		throw new BankUserNotFoundBasedOnNameAndAccountNumber("failed to Delete the bank user");
	}
	public ResponseEntity<ResponseStructiure<BankUser>> updateUserByNameAndAccountNumber(String name,
			long accountNumber, BankUserDto bankUserDto, String password) {
		BankUser BankUser=this.modelMapper.map(bankUserDto, BankUser.class);
		BankUser dbBankUser=userDao.getUserByNameAndPhnoneNumber(name,accountNumber,password);
		if (dbBankUser!=null)
		{
			BankUser data=userDao.updateBankUser(BankUser,dbBankUser);
				ResponseStructiure<BankUser> responseStructiure=new ResponseStructiure<BankUser>();  
				responseStructiure.setMessage("User is updated succesfully");
				responseStructiure.setObject(data);
				responseStructiure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructiure<BankUser>>(responseStructiure,HttpStatus.OK);
		}
		throw new BankUserNotFoundBasedOnNameAndAccountNumber("failed to fetch the bank user");
	}
	
}

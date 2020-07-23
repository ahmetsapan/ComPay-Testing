package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Generated;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@Generated(value = "src/main/resources/com/company/InStoreCredit.json")
@GraphWalker(value = "random(edge_coverage(100))", start = "v_Start", groups = { "default" })
public class InStoreCreditImpl extends ExecutionContext implements InStoreCredit {

	public final static Path MODEL_PATH = Paths.get("com/company/InStoreCredit.json");

	@Override
	public void v_CheckBankInfo() {
		System.out.println("Executing:v_CheckBankInfo");
	}

	@Override
	public void v_GetPayment() {
		System.out.println("Executing:v_GetPayment");
	}

	@Override
	public void e_GetPayment() {
		System.out.println("Executing:e_GetPayment");
	}

	@Override
	public void v_MerchantBankRelation() {
		System.out.println("Executing:v_MerchantBankRelation");
	}

	@Override
	public void v_Start() {
		System.out.println("Executing:v_Start");
	}

	@Override
	public void e_MerchantBankRelation() {
		System.out.println("Executing:e_MerchantBankRelation");
	}

	@Override
	public void e_Login() {
		System.out.println("Executing:e_Login");
	}

	@Override
	public void v_Login() {
		System.out.println("Executing:v_Login");
	}

	@Override
	public void e_CheckBankInfo() {
		System.out.println("Executing:e_CheckBankInfo");
	}

	@org.graphwalker.java.annotation.BeforeExecution
	public void _beforeExecution() {
		System.out.println("Executing: _beforeExecution");
	}

	@org.graphwalker.java.annotation.AfterExecution
	public void _afterExecution() {
		System.out.println("Executing: _afterExecution");
	}

	@org.graphwalker.java.annotation.BeforeElement
	public void _beforeElement() {
		System.out.println("Executing: _beforeElement");
	}

	@org.graphwalker.java.annotation.AfterElement
	public void _afterElement() {
		System.out.println("Executing: _afterElement");
	}

}

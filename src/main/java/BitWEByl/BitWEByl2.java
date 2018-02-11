package BitWEByl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitWEByl2 {
	
	double firstnumdouble = 0;
	double secondnumdouble = 0;
	int firstnuminteger = 0;
	int secondnuminteger = 0;
	
	int resultinteger = 0;
	double resultdouble = 0.0;
	boolean doublenum = false;
	
	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public String calculateGET(@RequestParam(value = "num1") String num1, 
			             @RequestParam(value = "num2") String num2,
			             @RequestParam(value = "op") String op) throws Exception{
		
		if((num1.matches("-?\\d+\\.\\d+") || num1.matches("-?\\d+")) && 
		   (num2.matches("-?\\d+\\.\\d+") || num2.matches("-?\\d+"))){
			if(num1.matches("-?\\d+\\.\\d+") || num2.matches("-?\\d+\\.\\d+")){
				firstnumdouble = Double.parseDouble(num1);
				secondnumdouble = Double.parseDouble(num2);
				doublenum = true;
			}
			else{
				firstnuminteger = Integer.parseInt(num1);
				secondnuminteger = Integer.parseInt(num2);
			}
		}
		else{
			throw new Exception("Unknown number!");
		}
		
		
		if(op.equals("sum")){
			if(doublenum){
				resultdouble = firstnumdouble + secondnumdouble;
			}
			else{
				resultinteger = firstnuminteger + secondnuminteger;
			}
		}
		else if(op.equals("sub")){
			if(doublenum){
				resultdouble = firstnumdouble - secondnumdouble;
			}
			else{
				resultinteger = firstnuminteger - secondnuminteger;
			}
		}
		else if(op.equals("prod")){
			if(doublenum){
				resultdouble = firstnumdouble * secondnumdouble;
			}
			else{
				resultinteger = firstnuminteger * secondnuminteger;
			}
		}
		else if(op.equals("div")){
			if(secondnumdouble == 0.0 || secondnuminteger == 0){
				throw new Exception("Dividing by zero is undefined!");
			}
			else if(doublenum){
				resultdouble = firstnumdouble / secondnumdouble;
			}
			else{
				if(firstnuminteger % secondnuminteger == 0){
					resultinteger = firstnuminteger / secondnuminteger;
				}
				else{
					resultdouble = (double) firstnuminteger / (double) secondnuminteger;
				}
			}
		}
		else{
			throw new Exception("Unknown operation!");
		}
		
		if(resultdouble != 0.0){
			if((resultdouble + "").endsWith(".0")){
				return (int) resultdouble + "";
			}
			else{
				return resultdouble + "";
			}
		}
		else{
			return resultinteger + "";
		}
	}

}

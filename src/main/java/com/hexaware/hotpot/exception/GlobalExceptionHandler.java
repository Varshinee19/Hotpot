package com.hexaware.hotpot.exception;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> CustomerNotFoundException() {
		return new ResponseEntity<String>("Customer Not Found ", HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<String> CustomerAlreadyExistsException(){
		return new ResponseEntity<String>("Customer already exits ", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<String> DuplicateEmailException(){
		return new ResponseEntity<String>("Email already exsits", HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(MenuNotFoundException.class)
	public ResponseEntity<String> MenuNotFoundException(){
		return new ResponseEntity<String>("Menu Does Not Exsist", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(OrderNotExistException.class)
	public ResponseEntity<String> OrderNotExistException(){
		return new ResponseEntity<String>("Order Could Not Be Found", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(OrderItemNotAvailableException.class)
	public ResponseEntity<String> ItemNotAvailableException(){
		return new ResponseEntity<String>("Item Not Available", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(RestaurantNotFoundException.class)
	public ResponseEntity<String> RestaurantNotFoundException(){
		return new ResponseEntity<String>("The Restaurant could not be found", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(RestaurantAlreadyExistsException.class)
	public ResponseEntity<String> RestaurantAlreadyExistException(){
		return new ResponseEntity<String>("The Restaurant already Exists", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidQuantityException.class)
	public ResponseEntity<String> InvalidQuantityException(){
		return new ResponseEntity<String>("Quantity should not be negative", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CartDoesNotExistException.class)
	public ResponseEntity<String> CartDoesNotExistException(){
		return new ResponseEntity<String>("Cart Does Not Exsist", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CartAlreadyExistsException.class)
	public ResponseEntity<String>CartAlreadyExistsException(){
		return new ResponseEntity<String>("Already there is a active cart.", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CartItemNotFoundException.class)
	public ResponseEntity<String> CartItemNotFoundException(){
		return new ResponseEntity<String>("Cart Item could not be found.", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> MethodArgumentNotValidException(){
		return new ResponseEntity<String>("Invalid Input Format.", HttpStatus.BAD_REQUEST);
	}
	
	

}

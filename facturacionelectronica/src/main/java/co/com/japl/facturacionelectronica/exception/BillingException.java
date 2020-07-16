package co.com.japl.facturacionelectronica.exception;

public class BillingException extends Exception{
  

   public BillingException(){
   	super();
   }

   public BillingException(String message){
   		super(message);
   }

   public BillingException(Throwable error){
   		super(error);
   }

   public BillingException(String message,Throwable error){
   		super(message,error);
   }

}
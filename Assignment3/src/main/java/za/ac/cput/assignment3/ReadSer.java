/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author keziah Robinson
 * 219113149
 * ADP Assignment3
 */
public class ReadSer {
ObjectInputStream read;
FileWriter writer; 
FileWriter writer2;
BufferedWriter buffWriter;
BufferedWriter buffWriter2;
ArrayList<Customer> customer= new ArrayList<Customer>();
ArrayList<Supplier> supplier= new ArrayList<Supplier>();








//------------------------------2A-Store in seperate array-lists--------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------   
 

    public void OpenFile(){
    try{
            read = new ObjectInputStream( new FileInputStream( "stakeholder.ser" ) ); 
            System.out.println("Ser file created!");               
}
    catch (IOException ioe){
            System.out.println("error opening Ser file: " + ioe.getMessage());
            System.exit(1);
}
}
    public void readFile(){
    try{
    while(true){
            Object object = read.readObject();
            String cust ="Customer";
            String supp = "Supplier";
            String name = object.getClass().getSimpleName();
    if ( name.equals(cust)){
            customer.add((Customer)object);
} 
    else if ( name.equals(supp)){
            supplier.add((Supplier)object);
} 
    else {
            System.out.println("failed");
}
} 
}
    catch (EOFException eofe) {
            System.out.println("End");
}
    catch (ClassNotFoundException ioe) {
            System.out.println("Class not found: "+ ioe);
}
    catch (IOException ioe) {
            System.out.println("Failed to read file: "+ ioe);
}
        
sortCustomer();
sortSupplier();        
}
    public void readCloseFile(){
    try{
            read.close( ); 
}
    catch (IOException ioe){            
            System.out.println("error closing file: " + ioe.getMessage());
            System.exit(1);
}
}
    
    
    
    
    
    
    
    
//------------------------------2B-Sort in ascending order--------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------
    public void sortCustomer(){
           String[] stakeId = new String[customer.size()];
           ArrayList<Customer> sortNewArray= new ArrayList<Customer>();
    int count = customer.size();
    for (int i = 0; i < count; i++) {
            stakeId[i] = customer.get(i).getStHolderId();
}
           Arrays.sort(stakeId);
        
    for (int i = 0; i < count; i++) {
    for (int j = 0; j < count; j++) {
    if (stakeId[i].equals(customer.get(j).getStHolderId())){
            sortNewArray.add(customer.get(j));
}
}
}       
    customer = sortNewArray;
}
    
//------------------------------2C-Determine Age--------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------  

//------------------------------2D-Format Date-----------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------
    public void sortDate(){
   

/*  
    //Scanner sc = new Scanner//     
    Date date = new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
    String stringDate= DateFor.format(date);
    System.out.println(stringDate);     
    String[] stakeId = new String[customer.size()];
    ArrayList<Customer> sortNewArray= new ArrayList<Customer>();
    int count = customer.size();
    for (int i = 0; i < count; i++) {
    stakeId[i] = customer.get(i).getStHolderId();
}
    Arrays.sort(stakeId);
        
    for (int i = 0; i < count; i++) {
    for (int j = 0; j < count; j++) {
    if (stakeId[i].equals(customer.get(j).getStHolderId())){
    sortNewArray.add(customer.get(j));
}
}
}
       
    customer = sortNewArray;
}
    */
   }    
   
    
    
    
    
    
    
    
    
   
//------------------------------2E-Write to customerOutFile.txt--------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------
    public void displayCustomersText() throws ParseException {
    try{
        
       //   PrintWriter out
       //   = new PrintWriter(new BufferedWriter(new FileWriter("writer.out")));
            writer = new FileWriter("customerOutFile.txt");
            buffWriter = new BufferedWriter(writer);
            buffWriter.write("==========================================CUSTOMER=================================================" + "\n"); 
            buffWriter.write(String.format("%-15s %-15s %-15s %-15s %-15s\n", "ID","Name","Surname","Date of Birth","Age"));
            buffWriter.write("===================================================================================================");
    for (int i = 0; i < customer.size(); i++) {
            buffWriter.write(String.format("\n" + "%-15s %-15s %-15s %-15s  \n", customer.get(i).getStHolderId(), customer.get(i).getFirstName(), customer.get(i).getSurName(), customer.get(i).getDateOfBirth()));
} 
      
    
    
    
    
    
    
//----------------------2F-Who can rent--------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------         
    int countTrue=0;
    int countfalse=0;
            Boolean canRent=true;
            Boolean cannotRent=false;
    for(int i=0;i<customer.size();i++)
    if(customer.get(i).getCanRent()==canRent)
        if(true){
{
            countTrue=countTrue +1; 
            countfalse=countfalse +1; 
}
        }
            buffWriter.write(String.format("%-20s %-20s \n \n", "\n" + "\nThe number of customers who can rent:  ",countTrue));
    for(int i=0;i<customer.size();i++)
    if(customer.get(i).getCanRent()==cannotRent)
    buffWriter.write(String.format("%-20s %-20s \n", "Number of customers who cannot rent:  ",countfalse));
    
    
        
            
}       
          
   
    catch(IOException fnfe )
{
            System.out.println(fnfe);
            System.exit(1);
}
    try{
            buffWriter.close(); 
            System.out.println("Successfully added customer");
}
    catch (IOException ioe){            
            System.out.println("error closing customer's text file: " + ioe.getMessage());
            System.exit(1);
}
}
    
    
    
    
    
    
    
    

//----------------------3A-Sort in ascending alphabetical order--------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------- 
    public void sortSupplier(){
    
        
         String[] sortName = new String[supplier.size()];
         ArrayList<Supplier> sortNewArray= new ArrayList<Supplier>();
    int alph = supplier.size();
    for (int i = 0; i < alph; i++) {
         sortName[i] = supplier.get(i).getName();
}
         Arrays.sort(sortName);
        
    for (int i = 0; i < alph; i++) {
    for (int j = 0; j < alph; j++) {
    if (sortName[i].equals(supplier.get(j).getName())){
         sortNewArray.add(supplier.get(j));
}
}
}
       
    supplier = sortNewArray;
        

}  
    
    
    
    
    
    
    
    
//----------------------3B-Write to supplierOutFile.txt--------------------------------------------------------------------------     
//-------------------------------------------------------------------------------------------------------------------------------     
public void displaySupplierText(){
    try{
            writer2 = new FileWriter("supplierOutFile.txt");
            buffWriter2 = new BufferedWriter(writer2);
            buffWriter2.write("================================SUPPLIER======================================" + "\n"); 
            buffWriter2.write(String.format("%-10s %-20s %-20s %-20s \n", "ID","Name","Prod Type","Description"));
            buffWriter2.write("=============================================================================="); 
           
    for (int i = 0; i < supplier.size(); i++) {
            buffWriter2.write(String.format("\n" + "%-10s %-20s %-20s %-20s  \n",supplier.get(i).getName(), supplier.get(i).getStHolderId(), supplier.get(i).getName(), supplier.get(i).getProductType(), supplier.get(i).getProductDescription()));
}
            buffWriter2.close();
            System.out.println("Successfully added supplier");
          
}
    catch(IOException fnfe )
{
            System.out.println(fnfe);
            System.exit(1);
}
    try{
            buffWriter2.close( ); 
}
    catch (IOException ioe){            
            System.out.println("error closing supplier's text file: " + ioe.getMessage());
            System.exit(1);
}
}     
     
            
    
  
    

     
//-------------------------------------------------------------------------------------------------------------------    
//-------------------------------------------------------------------------------------------------------------------------------
public static void main(String args[]) throws ParseException  {
ReadSer obj=new ReadSer(); 
obj.OpenFile();
obj.readFile();
obj.readCloseFile();
obj.displayCustomersText();
obj.displaySupplierText();








}   

}

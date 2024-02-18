public class Employee {
    String name;
    int salary;
    int workHours;
    int hireYear;

    // Constructor Employee method
    Employee (String name, int salary, int workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    // Calculates tax amount
    public double tax(){
        double taxAmount = 0.0;
        if(this.salary > 1000 ) {
            taxAmount = this.salary*0.03;
        }
        return taxAmount;
    }

    // Calculates salary bonus
    public double bonus(){
        double bonusAmount = 0.0;
        if(this.workHours > 40){
            bonusAmount =(this.workHours-40.0)*30.0;
        }
        return bonusAmount;
    }

    // Calculates salary raise amount
    public double raiseSalary(){
        double raisedSalary = 0.0;
        if((2021-hireYear) < 10){
            raisedSalary = (int) ( (this.salary*0.05));
        } else if ((2021-hireYear) < 9 &&  (2021-hireYear) < 20) {
            raisedSalary = (int) ((this.salary*0.1));
        } else if ((2021-hireYear) > 19) {
            raisedSalary = (int) ((this.salary*0.15));
        }
        return raisedSalary;
    }

    // Printing employee information
    public void printEmployee(){
        // Calculates salaries
        double salaryTaxBonus = this.salary-tax()+bonus();
        double totalSalary = salaryTaxBonus+raiseSalary();

        // Printing Results
        System.out.println("Name: " + this.name );
        System.out.println("Salary: " + this.salary+" ₺");
        System.out.println("Hire Year: " + this.hireYear+" ₺");
        System.out.println("Tax: " + tax() +" ₺");
        System.out.println("Bonus: " + bonus() +" ₺");
        System.out.println("Salary Increment: " + raiseSalary() +" ₺");
        System.out.println("Salary includes tax and bonus: " + salaryTaxBonus +" ₺");
        System.out.println("Total Salary: " + totalSalary +" ₺");
    }

}
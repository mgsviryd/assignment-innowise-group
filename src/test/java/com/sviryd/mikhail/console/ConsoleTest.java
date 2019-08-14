package com.sviryd.mikhail.console;

import com.sviryd.mikhail.console.option.ChosenOption;
import com.sviryd.mikhail.console.option.impl.AskingOption;
import com.sviryd.mikhail.console.option.impl.DeleteByIdOption;
import com.sviryd.mikhail.console.option.impl.EmailOption;
import com.sviryd.mikhail.console.option.impl.FirstNameOption;
import com.sviryd.mikhail.console.option.impl.RoleOption;
import com.sviryd.mikhail.console.option.impl.SaveUserOption;
import com.sviryd.mikhail.console.option.impl.SurnameOption;
import com.sviryd.mikhail.console.option.impl.NumberOption;
import org.junit.Test;

public class ConsoleTest {
    @Test
    public void console(){
        FirstNameOption firstNameOption = new FirstNameOption();
        AskingOption createUser = new AskingOption();
        createUser.setNext(firstNameOption);
        SurnameOption surnameOption = new SurnameOption();
        EmailOption emailOption = new EmailOption();
        RoleOption roleOption0 = new RoleOption(0);
        RoleOption roleOption1 = new RoleOption(1);
        RoleOption roleOption2 = new RoleOption(2);
        NumberOption numberOption0 = new NumberOption(0);
        NumberOption numberOption1 = new NumberOption(1);
        NumberOption numberOption2 = new NumberOption(2);
        SaveUserOption saveUserOption = new SaveUserOption();

        firstNameOption.setNext(surnameOption);
        surnameOption.setNext(emailOption);
        emailOption.setNext(roleOption0);
        
        AskingOption askRole1 = new AskingOption();
        askRole1.setNext(roleOption1);
        ChosenOption moreRoleOption1 = new ChosenOption(askRole1, numberOption0);
        roleOption0.setNext(moreRoleOption1);
        AskingOption askRole2 = new AskingOption();
        askRole2.setNext(roleOption2);
        ChosenOption moreRoleOption2 = new ChosenOption(askRole2, numberOption0);
        roleOption1.setNext(moreRoleOption2);
        AskingOption askRole3 = new AskingOption();
        askRole3.setNext(roleOption0);
        ChosenOption moreRoleOption3 = new ChosenOption(askRole3, numberOption0);
        roleOption2.setNext(moreRoleOption3);

        AskingOption askNumber1 = new AskingOption();
        askNumber1.setNext(numberOption1);
        ChosenOption moreNumberOption1 = new ChosenOption(askNumber1, saveUserOption);
        numberOption0.setNext(moreNumberOption1);
        AskingOption askNumber2 = new AskingOption();
        askNumber2.setNext(numberOption2);
        ChosenOption moreNumberOption2 = new ChosenOption(askNumber2, saveUserOption);
        numberOption1.setNext(moreNumberOption2);
        AskingOption askNumber3 = new AskingOption();
        askNumber3.setNext(numberOption0);
        ChosenOption moreNumberOption3 = new ChosenOption(askNumber3, saveUserOption);
        numberOption2.setNext(moreNumberOption3);

        DeleteByIdOption delete = new DeleteByIdOption();
        ChosenOption main = new ChosenOption();
        main.addOption(createUser);
        main.addOption(delete);


//        saveUserOption.setNext();
//        delete.setNext();

        


        Console console = new Console(new ConsoleUserModel(), main);
        console.open();
    }
}

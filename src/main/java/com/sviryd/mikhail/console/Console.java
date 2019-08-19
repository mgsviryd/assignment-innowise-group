package com.sviryd.mikhail.console;

import com.sviryd.mikhail.console.exception.ExitException;
import com.sviryd.mikhail.console.exception.RepeatPreventException;
import com.sviryd.mikhail.console.option.BoxOption;
import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.service.consoleUser.option.DeleteUserByIdOption;
import com.sviryd.mikhail.service.consoleUser.option.EmailOption;
import com.sviryd.mikhail.service.consoleUser.option.ExitOption;
import com.sviryd.mikhail.service.consoleUser.option.FindOneUserByIdOption;
import com.sviryd.mikhail.service.consoleUser.option.FirstNameUserOption;
import com.sviryd.mikhail.service.consoleUser.option.LastNameOption;
import com.sviryd.mikhail.service.consoleUser.option.NumberExcessOption;
import com.sviryd.mikhail.service.consoleUser.option.NumberOption;
import com.sviryd.mikhail.service.consoleUser.option.OpenOption;
import com.sviryd.mikhail.service.consoleUser.option.RoleExcessOption;
import com.sviryd.mikhail.service.consoleUser.option.RoleOption;
import com.sviryd.mikhail.service.consoleUser.option.SaveUserOption;
import com.sviryd.mikhail.service.consoleUser.option.ShowAllUsersOption;
import com.sviryd.mikhail.service.consoleUser.option.ShowOneUserByIdOption;
import com.sviryd.mikhail.service.consoleUser.option.UpdateUserOption;
import com.sviryd.mikhail.service.consoleUser.option.UploadUsersAppendToOldFileOption;
import com.sviryd.mikhail.service.consoleUser.option.UploadUsersInNewFileOption;
import com.sviryd.mikhail.service.consoleUser.option.UploadUsersRewriteOldFileOption;

import java.io.Closeable;
import java.util.Scanner;

public class Console implements Closeable {
    private ConsoleOptionHandler handler;
    private Scanner scanner;

    public Console(ConsoleOptionHandler handler) {
        this.handler = handler;
        this.scanner = new Scanner(System.in);
    }

    public Console(ConsoleOptionHandler handler, Scanner scanner) {
        this.handler = handler;
        this.scanner = scanner;
    }

    public void open() {
        Option next = handler.getMainOption();
        while (true) {
            showOption(next);
            try {
                next.process(scanner);
            } catch (ExitException e) {
                close();
                break;
            } catch (RepeatPreventException e) {
                showException(e);
                next = next.getNext();
                continue;
            } catch (Exception e) {
                showException(e);
                continue;
            }
            next = next.getNext();
        }
    }

    @Override
    public void close() {
        scanner.close();
    }

    private void showOption(Option o) {
        System.out.print(o);
    }

    private void showException(Exception e) {
        System.out.println(e.getMessage());
    }


    public static void main(String[] args) {
        final ConsoleOptionHandler handler = new ConsoleOptionHandler();

        // OPEN
        final OpenOption open = new OpenOption("OPEN\n");
        handler.addOption(1, open);
        handler.setOpenOption(1);

        // MAIN
        final FirstNameUserOption firstNameUserOption = new FirstNameUserOption("Enter first name: ");
        final FindOneUserByIdOption findOneUserByIdUpdateOption = new FindOneUserByIdOption("Enter user id: ");
        final DeleteUserByIdOption deleteUserByIdOption = new DeleteUserByIdOption("Enter user id: ");
        final ShowOneUserByIdOption showOneUserByIdOption = new ShowOneUserByIdOption("Enter user id: ");
        final ShowAllUsersOption showAllUsersOption = new ShowAllUsersOption("User list:\\n");
        final UploadUsersInNewFileOption uploadUsersInNewFileOption = new UploadUsersInNewFileOption("Enter absolute path to file (including file name): ");
        final UploadUsersRewriteOldFileOption uploadUsersRewriteOldFileOption = new UploadUsersRewriteOldFileOption("Enter absolute path to file (including file name): ");
        final UploadUsersAppendToOldFileOption uploadUsersAppendToOldFileOption = new UploadUsersAppendToOldFileOption("Enter absolute path to file (including file name): ");
        final ExitOption exitOption = new ExitOption("EXIT");
        handler.addOption(2, firstNameUserOption);
        handler.addOption(3, findOneUserByIdUpdateOption);
        handler.addOption(4, deleteUserByIdOption);
        handler.addOption(5, showOneUserByIdOption);
        handler.addOption(6, showAllUsersOption);
        handler.addOption(7, uploadUsersInNewFileOption);
        handler.addOption(8, uploadUsersRewriteOldFileOption);
        handler.addOption(9, uploadUsersAppendToOldFileOption);
        handler.addOption(10, exitOption);

        final BoxOption main = new BoxOption("Options:\n");
        main.addOption("Create user", firstNameUserOption);
        main.addOption("Update user", findOneUserByIdUpdateOption);
        main.addOption("Delete user", deleteUserByIdOption);
        main.addOption("Show user", showOneUserByIdOption);
        main.addOption("Show all users", showAllUsersOption);
        main.addOption("Upload in new file", uploadUsersInNewFileOption);
        main.addOption("Upload in old file (rewrite)", uploadUsersRewriteOldFileOption);
        main.addOption("Upload in old file (append)", uploadUsersAppendToOldFileOption);
        main.addOption("Exit", exitOption);
        handler.addOption(10, main);
        handler.setNext(1, 10);

        // CREATE USER
        final LastNameOption lastNameOption = new LastNameOption("Enter last name: ");
        final EmailOption emailOption = new EmailOption("Enter email: ");
        final RoleOption roleOption1 = new RoleOption("Enter role(1): ");
        final RoleOption roleOption2 = new RoleOption("Enter role(2): ");
        final RoleOption roleOption3 = new RoleOption("Enter role(3): ");
        final RoleExcessOption roleExcessOption = new RoleExcessOption("Enter role: ");
        final NumberOption numberOption1 = new NumberOption("Enter phone number(1): ");
        final NumberOption numberOption2 = new NumberOption("Enter phone number(2): ");
        final NumberOption numberOption3 = new NumberOption("Enter phone number(3): ");
        final NumberExcessOption numberExcessOption = new NumberExcessOption("Enter phone number: ");
        final SaveUserOption saveUserOption = new SaveUserOption("User is saved.\n");

        final BoxOption choseRole2 = new BoxOption("Options:\n");
        choseRole2.addOption("Do you want to enter one more role?", roleOption2);
        choseRole2.addOption("Do you want to enter the next field?", numberOption1);
        final BoxOption choseRole3 = new BoxOption("Options:\n");
        choseRole3.addOption("Do you want to enter one more role?", roleOption3);
        choseRole3.addOption("Do you want to enter the next field?", numberOption1);
        final BoxOption oneMoreRole = new BoxOption("Options:\n");
        oneMoreRole.addOption("Do you want add one more role?", roleExcessOption);
        oneMoreRole.addOption("Do you want to enter the next field?", numberOption1);
        final BoxOption choseNumber2 = new BoxOption("Options:\n");
        choseNumber2.addOption("Do you want to enter one more number?", numberOption2);
        choseNumber2.addOption("Do you want to save new user?", saveUserOption);
        final BoxOption choseNumber3 = new BoxOption("Options:\n");
        choseNumber3.addOption("Do you want to enter one more role?", numberOption3);
        choseNumber3.addOption("Do you want to save new user?", saveUserOption);
        final BoxOption oneMoreNumber = new BoxOption("Options:\n");
        oneMoreNumber.addOption("Do you want add one more phone number?", numberExcessOption);
        oneMoreNumber.addOption("Do you want to save new user?", saveUserOption);
        handler.addOption(11, lastNameOption);
        handler.addOption(12, emailOption);
        handler.addOption(13, roleOption1);
        handler.addOption(14, choseRole2);
        handler.addOption(15, roleOption2);
        handler.addOption(16, choseRole3);
        handler.addOption(17, roleOption3);
        handler.addOption(18, oneMoreRole);
        handler.addOption(19, roleExcessOption);
        handler.addOption(20, numberOption1);
        handler.addOption(21, choseNumber2);
        handler.addOption(22, numberOption2);
        handler.addOption(23, choseNumber3);
        handler.addOption(24, numberOption3);
        handler.addOption(25, oneMoreNumber);
        handler.addOption(26, numberExcessOption);
        handler.addOption(27, saveUserOption);

        handler.setNext(2, 11);
        handler.setNext(11, 12);
        handler.setNext(12, 13);
        handler.setNext(13, 14);
        handler.setNext(15, 16);
        handler.setNext(17, 18);
        handler.setNext(19, 13);

        handler.setNext(20, 21);
        handler.setNext(22, 23);
        handler.setNext(24, 25);
        handler.setNext(26, 20);
        handler.setNext(27, 10);

        // UPDATE USER
        final FirstNameUserOption firstNameUpdateUserOption = new FirstNameUserOption("Enter first name: ");
        final LastNameOption lastNameUpdateOption = new LastNameOption("Enter last name: ");
        final EmailOption emailUpdateOption = new EmailOption("Enter email: ");
        final RoleOption roleUpdateOption1 = new RoleOption("Enter role(1): ");
        final RoleOption roleUpdateOption2 = new RoleOption("Enter role(2): ");
        final RoleOption roleUpdateOption3 = new RoleOption("Enter role(3): ");
        final RoleExcessOption roleUpdateExcessOption = new RoleExcessOption("Enter role: ");
        final NumberOption numberUpdateOption1 = new NumberOption("Enter phone number(1): ");
        final NumberOption numberUpdateOption2 = new NumberOption("Enter phone number(2): ");
        final NumberOption numberUpdateOption3 = new NumberOption("Enter phone number(3): ");
        final NumberExcessOption numberUpdateExcessOption = new NumberExcessOption("Enter phone number: ");
        final UpdateUserOption updateUserOption = new UpdateUserOption("User is updated.\n");

        final BoxOption selectField = new BoxOption("Update field:\n");
        selectField.addOption("first name", firstNameUpdateUserOption);
        selectField.addOption("last name", lastNameUpdateOption);
        selectField.addOption("email", emailUpdateOption);
        selectField.addOption("roles", roleUpdateOption1);
        selectField.addOption("number", numberUpdateOption1);
        selectField.addOption("Save changes", updateUserOption);

        final BoxOption choseUpdateRole2 = new BoxOption("Options:\n");
        choseUpdateRole2.addOption("Do you want to change one more role?", roleUpdateOption2);
        choseUpdateRole2.addOption("Go back to fields?", selectField);
        final BoxOption choseUpdateRole3 = new BoxOption("Options:\n");
        choseUpdateRole3.addOption("Do you want to enter one more role?", roleUpdateOption3);
        choseUpdateRole3.addOption("Go back to fields?", selectField);
        final BoxOption oneMoreUpdateRole = new BoxOption("Options:\n");
        oneMoreUpdateRole.addOption("Do you want add one more role?", roleUpdateExcessOption);
        oneMoreUpdateRole.addOption("Go back to fields?", selectField);
        final BoxOption choseUpdateNumber2 = new BoxOption("Options:\n");
        choseUpdateNumber2.addOption("Do you want to enter one more number?", numberUpdateOption2);
        choseUpdateNumber2.addOption("Go back to fields?", selectField);
        final BoxOption choseUpdateNumber3 = new BoxOption("Options:\n");
        choseUpdateNumber3.addOption("Do you want to enter one more role?", numberUpdateOption3);
        choseUpdateNumber3.addOption("Go back to fields?", selectField);
        final BoxOption oneMoreUpdateNumber = new BoxOption("Options:\n");
        oneMoreUpdateNumber.addOption("Do you want add one more phone number?", numberUpdateExcessOption);
        oneMoreUpdateNumber.addOption("Go back to fields?", selectField);
        handler.addOption(30, firstNameUpdateUserOption);
        handler.addOption(31, lastNameUpdateOption);
        handler.addOption(32, emailUpdateOption);
        handler.addOption(33, roleUpdateOption1);
        handler.addOption(34, choseUpdateRole2);
        handler.addOption(35, roleUpdateOption2);
        handler.addOption(36, choseUpdateRole3);
        handler.addOption(37, roleUpdateOption3);
        handler.addOption(38, oneMoreUpdateRole);
        handler.addOption(39, roleUpdateExcessOption);
        handler.addOption(40, numberUpdateOption1);
        handler.addOption(41, choseUpdateNumber2);
        handler.addOption(42, numberUpdateOption2);
        handler.addOption(43, choseUpdateNumber3);
        handler.addOption(44, numberUpdateOption3);
        handler.addOption(45, oneMoreUpdateNumber);
        handler.addOption(46, numberUpdateExcessOption);
        handler.addOption(47, updateUserOption);
        handler.addOption(48, selectField);
        handler.setNext(3, 48);
        handler.setNext(30, 48);
        handler.setNext(31, 48);
        handler.setNext(32, 48);
        handler.setNext(33, 34);
        handler.setNext(35,36);
        handler.setNext(37, 38);
        handler.setNext(39, 33);
        handler.setNext(40, 41);
        handler.setNext(42,43);
        handler.setNext(44,45);
        handler.setNext(46, 40);
        handler.setNext(47, 10);

        Scanner scanner = new Scanner(System.in);
        Console console = new Console(handler, scanner);
        console.open();
    }
}

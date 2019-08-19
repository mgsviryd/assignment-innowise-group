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
        this.scanner.useDelimiter("\n");
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
        final OpenOption open = new OpenOption("OPEN\n");
        handler.addOption(0, open);
        handler.setOpenOption(0);

        final FirstNameUserOption firstNameUserOption = new FirstNameUserOption("Enter first name: ");
        final FindOneUserByIdOption findOneUserByIdOption = new FindOneUserByIdOption("Enter user id: ");
        final DeleteUserByIdOption deleteUserByIdOption = new DeleteUserByIdOption("Enter user id: ");
        final ShowOneUserByIdOption showOneUserByIdOption = new ShowOneUserByIdOption("Enter user id: ");
        final ShowAllUsersOption showAllUsersOption = new ShowAllUsersOption("User list:\\n");
        final UploadUsersInNewFileOption uploadUsersInNewFileOption = new UploadUsersInNewFileOption("Enter absolute path to file (including file name): ");
        final UploadUsersRewriteOldFileOption uploadUsersRewriteOldFileOption = new UploadUsersRewriteOldFileOption("Enter absolute path to file (including file name): ");
        final UploadUsersAppendToOldFileOption uploadUsersAppendToOldFileOption = new UploadUsersAppendToOldFileOption("Enter absolute path to file (including file name): ");
        final ExitOption exitOption = new ExitOption("EXIT");
        handler.addOption(2, firstNameUserOption);
        handler.addOption(3, findOneUserByIdOption);
        handler.addOption(4, deleteUserByIdOption);
        handler.addOption(5, showOneUserByIdOption);
        handler.addOption(6, showAllUsersOption);
        handler.addOption(7, uploadUsersInNewFileOption);
        handler.addOption(8, uploadUsersRewriteOldFileOption);
        handler.addOption(9, uploadUsersAppendToOldFileOption);
        handler.addOption(10, exitOption);

        final BoxOption main = new BoxOption("Options:\n");
        main.addOption("Create user", firstNameUserOption);
        main.addOption("Update user", findOneUserByIdOption);
        main.addOption("Delete user", deleteUserByIdOption);
        main.addOption("Show user", showOneUserByIdOption);
        main.addOption("Show all users", showAllUsersOption);
        main.addOption("Upload in new file", uploadUsersInNewFileOption);
        main.addOption("Upload in old file (rewrite)", uploadUsersRewriteOldFileOption);
        main.addOption("Upload in old file (append)", uploadUsersAppendToOldFileOption);
        main.addOption("Exit", exitOption);
        handler.addOption(10, main);
        handler.setNext(0, 10);

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
        final SaveUserOption saveUserOption = new SaveUserOption("Save user");

        final BoxOption oneMoreRole = new BoxOption("Options:\n");
        oneMoreRole.addOption("Do you want add one more role?", roleExcessOption);
        oneMoreRole.addOption("Do you want to enter the next field?", numberOption1);
        final BoxOption oneMoreNumber = new BoxOption("Options:\n");
        oneMoreNumber.addOption("Do you want add one more phone number?", numberExcessOption);
        oneMoreNumber.addOption("Do you want to save new user?", saveUserOption);
        handler.addOption(11, lastNameOption);
        handler.addOption(12, emailOption);
        handler.addOption(13, roleOption1);
        handler.addOption(14, roleOption2);
        handler.addOption(15, roleOption3);
        handler.addOption(16, oneMoreRole);
        handler.addOption(17, roleExcessOption);
        handler.addOption(18, numberOption1);
        handler.addOption(19, numberOption2);
        handler.addOption(20, numberOption3);
        handler.addOption(21, oneMoreNumber);
        handler.addOption(22, numberExcessOption);
        handler.addOption(23, saveUserOption);

        handler.setNext(2, 11);
        handler.setNext(11, 12);
        handler.setNext(12, 13);
        handler.setNext(13, 14);
        handler.setNext(14, 15);
        handler.setNext(15, 16);
        handler.setNext(17, 13);
        handler.setNext(18, 19);
        handler.setNext(19, 20);
        handler.setNext(20, 21);
        handler.setNext(22, 18);
        handler.setNext(23, 10);

        Scanner scanner = new Scanner(System.in);
        Console console = new Console(handler, scanner);
        console.open();
    }
}

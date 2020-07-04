# Bank-Project
Bank Management project. Read README for details.
Functions performed:
1. Login page-> Home-page/Sign up
2. Home page-> AddDetails(income) or Deposit or withdraw or logout3
3.Transfer money
4.Reset password
5. Logout-> Login page
6. Stores all data in database(bank)-mysql db used.
since new Eclipse 2020-6 even after installing JavaFx from Eclipse marketplace eclipse ide was not able to detect javafx files.
To resolve this error I have manually downloaded JavaFx jar file and following steps are to be performed.
Add user lib JavaFx, them run as configuration-> Arguments->vm arguments->paste the below path.
--module-path "D:\JFx\javafx-sdk-11.0.2\lib\"  --add-modules=javafx.controls,javafx.fxml(if it does't work remove quotes from path);
--module-path D:\JFx\javafx-sdk-11.0.2\lib\  --add-modules=javafx.controls,javafx.fxml(without quotes)

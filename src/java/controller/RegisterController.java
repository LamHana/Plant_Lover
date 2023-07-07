/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountDAO;
import model.AccountDTO;
import model.UserDTO;
import model.UserError;
import model.UserGoogleDTO;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author Hana
 */
public class RegisterController extends HttpServlet {

    private static final String ERROR = "register.jsp";
    private static final String SUCCESS = "ProductController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userError = new UserError();
        try {
            AccountDAO dao = new AccountDAO();
            boolean checkValidation = true;
            HttpSession session = request.getSession();
            String email = request.getParameter("email");
            boolean isValidEmail = email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
            if (!isValidEmail) {
                userError.setEmailError("Email is invalid!!");
                checkValidation = false;
            }

            boolean checkDuplicate = dao.checkDuplicate(email);
            if (checkDuplicate) {
                userError.setEmailError("Duplicate Email!!!");
                checkValidation = false;
            }
            String userName = request.getParameter("fullname");
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phoneNumber");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            if (userName.length() < 5 || userName.length() > 30) {
                userError.setFullNameError("User id must be in [5,30]");
                checkValidation = false;
            }

            boolean isValidPhoneNumber = phoneNumber.matches("^(\\+?84|0)(3[2-9]|5[2689]|7[06789]|8[1-689]|9[0-9])[0-9]{7}$");
            if (!isValidPhoneNumber) {
                userError.setPhoneNumberError("Phone number is invalid!!");
                checkValidation = false;
            }
            if (!password.equals(confirm)) {
                userError.setConfirmError("Those password does not match !!");
                checkValidation = false;
            }

            // Recipient's email ID needs to be mentioned.
            String to = email;

            // Sender's email ID needs to be mentioned
            String from = "lamtngochan@gmail.com";

            // Assuming you are sending email from localhost
            String host = "smtp.elasticemail.com";
            String username = "lamtngochan@gmail.com";
            String passwordHost = "0CB4D40997EA5D80A319D8E8AFDBA11EEC70";
            int smtpPort = 2525;
            // Get system properties
            Properties properties = System.getProperties();

            // Setup mail server
            properties.setProperty("mail.smtp.host", host);
            properties.setProperty("mail.smtp.port", String.valueOf(smtpPort));

            // Set authentication properties
            properties.setProperty("mail.smtp.auth", "true");
            properties.setProperty("mail.smtp.user", username);
            properties.setProperty("mail.smtp.password", passwordHost);

            // Create a new Authenticator instance
            Authenticator authenticator = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, passwordHost);
                }
            };
            // Get the default Session object.
            Session emailSession = Session.getDefaultInstance(properties, authenticator);

            try {
                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(emailSession);

                // Set From: header field of the header.
                message.setFrom(new InternetAddress(from));

                // Set To: header field of the header.
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                // Set Subject: header field
                message.setSubject("This is the Subject Line!");

                // Send the actual HTML message, as big as you like
                message.setContent("<div class=\"im\">"
                        + "  <div style=\"padding:0;margin:0;background:#fffaf7\">"
                        + "    <table style=\"height:100%;width:100%;background-color:rgb(255,250,247)\" align=\"center\">"
                        + "      <tbody>"
                        + "        <tr>"
                        + "          <td valign=\"top\" id=\"m_2344596725796504947dbody\" style=\"width:100%;height:100%;padding-top:50px;padding-bottom:50px;background-color:rgb(255,250,247)\">"
                        + "            "
                        + "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:600px;box-sizing:border-box;width:100%;margin:0px auto\">"
                        + "              <tbody>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"font-family:&quot;Times New Roman&quot;,Times,serif;font-size:14px;padding:20px;text-align:left;color:rgb(95,95,95);word-break:break-word;direction:ltr;box-sizing:border-box\">"
                        + "                              <p style=\"text-align:right;font-size:9px;margin:0px;padding:0px\"> Unable to view? Read it"
                        + "                                <span style=\"color:#be5845\"></span>"
                        + "                                <a href=\"https://1AAMN.trk.elasticemail.com/view?msgid=qCkbOqleKCNDGYm30VXEBg2\" style=\"font-size:9px;color:rgb(255,200,44);text-decoration:none\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://1AAMN.trk.elasticemail.com/view?msgid%3DqCkbOqleKCNDGYm30VXEBg2&amp;source=gmail&amp;ust=1687855131080000&amp;usg=AOvVaw1p8Ou71T1D1Ig9pF9lnxU-\"><strong><span style=\"color:#000000\">Online</span></strong></a></p>"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"font-size:12px;padding:20px;box-sizing:border-box;text-align:center\">"
                        + "                              <img src=\"https://ci4.googleusercontent.com/proxy/YqU78Nb78zaHwelAJVpbXx-AMRvXsBG52Kn23VGORt8ozHKX31Ci-ChcLE3Qj7xDX3iO8c9NYS5Bi6C6Tq0fWaykaCGEG6DfyFYMGb_v8Okj7ukau0qypPpSJMZlyeP7Y8rT7SjVwA=s0-d-e1-ft#https://api.smtprelay.co/userfile/ee5f5396-eefa-4baf-af9b-9c8b204cb2db/main-logo.png\" alt=\"Image\" style=\"border-width:0px;border-style:none;max-width:214px;width:100%\" width=\"214\" class=\"CToWUd\" data-bit=\"iit\">"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:5px\">"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:0px;font-size:12px;box-sizing:border-box;text-align:center\">"
                        + "                              <img src=\"https://ci5.googleusercontent.com/proxy/fVD5ZCDUS5kDUbmvuYF4Inx3OykcwEoWGWWBk7yVvq1DrSHWKh6SQU7T8YgUyoyG6V-TTl0yhpBB0NHKPUI8po2RWON2elBteezIRXgeG3msbS9MF6vgZ0EPD5WmVzdXSNEX_rA7Sf9UlA5tMKbEQOQ=s0-d-e1-ft#https://api.elasticemail.com/userfile/a18de9fc-4724-42f2-b203-4992ceddc1de/deco_footer_dot.png\" alt=\"Image\" width=\"600\" style=\"border-width:0px;border-style:none;max-width:600px;width:100%\" class=\"CToWUd\" data-bit=\"iit\">"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:24px;font-family:&quot;Times New Roman&quot;,Times,serif;font-size:14px;text-align:left;color:rgb(95,95,95);word-break:break-word;direction:ltr;box-sizing:border-box\">"
                        + "                              <p style=\"text-align:center;margin:0px;padding:0px\"><em>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Welcome to our plant paradise, where green dreams come true.</em></p><p style=\"text-align:center;margin:0px;padding:0px\"><em>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Explore our stunning collection&nbsp; and</em></p><p style=\"text-align:center;margin:0px;padding:0px\"><em>&nbsp; &nbsp;bring nature's beauty into&nbsp;</em></p><p style=\"text-align:center;margin:0px;padding:0px\"><em>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;your space with ease.&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</em>&nbsp;</p>"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:5px\">"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:0px\">"
                        + "                              <p style=\"border-style:solid none none;border-width:3px 0px 0px;margin:8px 100px;padding:0px\">&nbsp;"
                        + "                              </p>"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:20px\">"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:300px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:0px;font-size:12px;box-sizing:border-box;text-align:center\">"
                        + "                              <img src=\"https://ci5.googleusercontent.com/proxy/oD7GMx6aOjQ-EZTs_dhw4Z6sau8NruzL27rJti6aztCrXVXPrpEyAEODTmcQw1OzLBZ2z5G74WeH06WJ81jp3Y9sNT7SsaqzmcgwthA5mP9TtUctUd0plSfA5_1OpC3Q6I_fXn8FUWw=s0-d-e1-ft#https://api.elasticemail.com/userfile/a18de9fc-4724-42f2-b203-4992ceddc1de/hand_1.png\" alt=\"Image\" width=\"300\" style=\"border-width:0px;border-style:none;max-width:300px;width:100%\" class=\"CToWUd a6T\" data-bit=\"iit\" tabindex=\"0\"><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 470.825px; top: 682.1px;\"><div id=\":np\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\" title=\"Download\" role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" jslog=\"91252; u014N:cOuCgd,Kr2w4b,xr6bB; 4:WyIjbXNnLWY6MTc2OTQ4MzcxMTk1MTU2NTU2MyIsbnVsbCxbXV0.\" data-tooltip-class=\"a1V\"><div class=\"akn\"><div class=\"aSK J-J5-Ji aYr\"></div></div></div></div>"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:300px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:36px;font-family:&quot;Times New Roman&quot;,Times,serif;font-size:14px;text-align:left;color:rgb(95,95,95);word-break:break-word;direction:ltr;box-sizing:border-box\"><p style=\"text-align:center;margin:0px;padding:0px\">"
                        + "                                <br>"
                        + "                              </p>"
                        + "<p style=\"margin:0px;padding:0px\">We strive to bring nature's wonders right to your doorstep.&nbsp;</p>"
                        + "<p style=\"margin:0px;padding:0px\">"
                        + "                                <br>"
                        + "                              </p>"
                        + "<p style=\"margin:0px;padding:0px\"><strong><span style=\"color:#006e61\"><span style=\"color:#000000\">Join with us&nbsp;</span>"
                        + "                                    <strong>"
                        + "                                      <span style=\"color:#000000\">➜</span>"
                        + "                                    </strong></span>"
                        + "                                </strong>"
                        + "                                <br>"
                        + "                              </p></td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:0px;font-size:12px;box-sizing:border-box;text-align:center\">"
                        + "                              <img src=\"https://ci6.googleusercontent.com/proxy/lc5sDjHAkehpRhG8Ek-eBaZRet7ei94Q0BVQv3fKywItvU6colfG6iJ5ZYpdaOmSxHPtB7HR2wk7emSgL2M2NJ5zg9-lOnlWATQQ5sdlKX77Wad4uUC5buGxBAnaSTPSXUMABnB-PQ=s0-d-e1-ft#https://api.elasticemail.com/userfile/a18de9fc-4724-42f2-b203-4992ceddc1de/Ideas.png\" alt=\"Image\" width=\"807\" style=\"border-width:0px;border-style:none;max-width:807px;width:100%\" class=\"CToWUd a6T\" data-bit=\"iit\" tabindex=\"0\"><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 770.825px; top: 866.775px;\"><div id=\":nn\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\" title=\"Download\" role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" jslog=\"91252; u014N:cOuCgd,Kr2w4b,xr6bB; 4:WyIjbXNnLWY6MTc2OTQ4MzcxMTk1MTU2NTU2MyIsbnVsbCxbXV0.\" data-tooltip-class=\"a1V\"><div class=\"akn\"><div class=\"aSK J-J5-Ji aYr\"></div></div></div></div>"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:36px;font-family:&quot;Times New Roman&quot;,Times,serif;font-size:14px;text-align:left;color:rgb(95,95,95);word-break:break-word;direction:ltr;box-sizing:border-box\"><p style=\"text-align:center;margin:0px;padding:0px\"><span style=\"font-size:18px;color:#000000\">➊&nbsp;</span><br></p>"
                        + "<p style=\"text-align:center;margin:0px;padding:0px\">&nbsp;Elevate your well-being with our plants that improve air quality, reduce stress, and promote a healthier lifestyle."
                        + "                              </p>"
                        + "<p style=\"text-align:center;margin:0px;padding:0px\">"
                        + "                              </p>"
                        + "<p style=\"margin:0px;padding:0px\"><br></p>"
                        + "<p style=\"text-align:center;margin:0px;padding:0px\">"
                        + "                                <span style=\"font-size:18px;color:#000000\">➋&nbsp;</span><br>"
                        + "                              </p>"
                        + "<p style=\"margin:0px;padding:0px\">"
                        + "                                <span style=\"color:#000000\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>&nbsp;Choose from a diverse selection of plants, ranging from classics to rare varieties, all available conveniently on our e-commerce website. &nbsp;"
                        + "                              </p>"
                        + "<p style=\"text-align:center;margin:0px;padding:0px\">"
                        + "                              </p>"
                        + "<p style=\"margin:0px;padding:0px\"><br></p>"
                        + "<p style=\"text-align:center;margin:0px;padding:0px\">"
                        + "                                <span style=\"font-size:18px;color:#000000\">➌&nbsp;</span><br>"
                        + "                              </p>"
                        + "<p style=\"text-align:center;margin:0px;padding:0px\">&nbsp;Choose from a diverse selection of plants, ranging from classics to rare varieties, all available conveniently on our e-commerce website. &nbsp;"
                        + "                              </p>"
                        + "<p style=\"text-align:center;margin:0px;padding:0px\">"
                        + "</p>"
                        + "<p style=\"margin:0px;padding:0px\"><br></p>"
                        + "<p style=\"text-align:center;margin:0px;padding:0px\">"
                        + "                                <span style=\"font-size:18px;color:#000000\">➍&nbsp;</span><br>"
                        + "                              </p>"
                        + "<p style=\"text-align:center;margin:0px;padding:0px\"><span style=\"text-align:left\">&nbsp;Enjoy a hassle-free shopping experience with our user-friendly website and convenient doorstep delivery, bringing nature's beauty right to your home. &nbsp;</span>"
                        + "                              </p>"
                        + "<p style=\"text-align:center;margin:0px;padding:0px\">"
                        + "                              </p></td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:0px;font-size:12px;box-sizing:border-box;text-align:center\">"
                        + "                              <img src=\"https://ci4.googleusercontent.com/proxy/fKrfan61czzYtKJVyCNc-pphC0lQMlZ5xOZ4c8IpdHJHfRTN8-9urOJOvrW6OEpdAkkNewE3wybBa8MnT9qCbZd1FXRLZ2pGxktk7WVrPWxNpzFmP7UswfjlZ_vy8ysL56BX7oIkvKk=s0-d-e1-ft#https://api.elasticemail.com/userfile/a18de9fc-4724-42f2-b203-4992ceddc1de/hand_2.png\" alt=\"Image\" width=\"318\" style=\"border-width:0px;border-style:none;max-width:318px;width:100%\" class=\"CToWUd a6T\" data-bit=\"iit\" tabindex=\"0\"><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 629.825px; top: 1515.15px;\"><div id=\":no\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\" role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" jslog=\"91252; u014N:cOuCgd,Kr2w4b,xr6bB; 4:WyIjbXNnLWY6MTc2OTQ4MzcxMTk1MTU2NTU2MyIsbnVsbCxbXV0.\" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"><div class=\"akn\"><div class=\"aSK J-J5-Ji aYr\"></div></div></div></div>"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:24px;font-family:&quot;Times New Roman&quot;,Times,serif;font-size:14px;text-align:left;color:rgb(95,95,95);word-break:break-word;direction:ltr;box-sizing:border-box\"><p style=\"text-align:center;margin:0px;padding:0px\">"
                        + "                                <br>"
                        + "                              </p>"
                        + "<p style=\"text-align:center;margin:0px;padding:0px\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;We're excited to be your go-to destination for all things plant-related. Welcome aboard!&nbsp;&nbsp;</p></td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:24px\">"
                        + "                              <table cellspacing=\"0\" cellpadding=\"0\" style=\"text-align:center;margin:0px auto\" align=\"center\">"
                        + "                                <tbody>"
                        + "                                  <tr>"
                        + "                                    <td align=\"center\" style=\"border-radius:8px;padding:9px;background:rgb(0,0,0)\">"
                        + "                                      <a style=\"font-size:14px;word-break:break-word;color:rgb(255,255,255);font-family:&quot;Open Sans&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif;font-weight:normal;text-decoration:none;display:inline-block\"><span style=\"color:rgb(255,255,255)\">Join with us</span></a></td>"
                        + "                                  </tr>"
                        + "                                </tbody>"
                        + "                              </table>"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:8px\">"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                "
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(255,250,247);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:32px\">"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(224,224,204);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"font-size:12px;padding:20px;box-sizing:border-box;text-align:center\">"
                        + "                              <img src=\"https://ci5.googleusercontent.com/proxy/fVD5ZCDUS5kDUbmvuYF4Inx3OykcwEoWGWWBk7yVvq1DrSHWKh6SQU7T8YgUyoyG6V-TTl0yhpBB0NHKPUI8po2RWON2elBteezIRXgeG3msbS9MF6vgZ0EPD5WmVzdXSNEX_rA7Sf9UlA5tMKbEQOQ=s0-d-e1-ft#https://api.elasticemail.com/userfile/a18de9fc-4724-42f2-b203-4992ceddc1de/deco_footer_dot.png\" alt=\"Image\" width=\"560\" style=\"border-width:0px;border-style:dashed;border-color:rgb(0,110,97);max-width:560px;width:100%\" class=\"CToWUd\" data-bit=\"iit\">"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                <tr><td valign=\"top\" align=\"center\" style=\"background-color:rgb(224,224,204);box-sizing:border-box;font-size:0px;text-align:center\"><div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"font-family:&quot;Times New Roman&quot;,Times,serif;font-size:14px;padding:20px;text-align:left;color:rgb(95,95,95);word-break:break-word;direction:ltr;box-sizing:border-box\">"
                        + "                              <p style=\"text-align:center;margin:0px;padding:0px\"><span style=\"color:rgb(0,0,0)\"><u></u>If you no longer wish to receive mail from us, you can&nbsp;<span style=\"color:rgb(255,0,0)\">Unsubscribe</span></span></p><p style=\"text-align:center;margin:0px;padding:0px\"><span style=\"font-size:14px\"><span style=\"color:rgb(0,0,255)\"><u>lamtngochan@gmai</u></span><span style=\"color:rgb(0,0,255)\"><u><a href=\"http://l.com\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=http://l.com&amp;source=gmail&amp;ust=1687855131080000&amp;usg=AOvVaw3kYGwLRY_LLCBePegaUTJt\">l.com</a></u></span></span></p>"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div></td></tr>"
                        + "                "
                        + "                <tr>"
                        + "                  <td valign=\"top\" align=\"center\" style=\"background-color:rgb(224,224,204);box-sizing:border-box;font-size:0px;text-align:center\">"
                        + "                    "
                        + "                    <div class=\"m_2344596725796504947layer_2\" style=\"max-width:600px;display:inline-block;vertical-align:top;width:100%\">"
                        + "                      <table border=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;width:100%\">"
                        + "                        <tbody>"
                        + "                          <tr>"
                        + "                            <td valign=\"top\" style=\"padding:20px\">"
                        + "                              <table align=\"center\" style=\"margin:0px auto\" class=\"m_2344596725796504947edsocialfollowcontainer\" cellpadding=\"0\" border=\"0\" cellspacing=\"0\">"
                        + "                                <tbody>"
                        + "                                  <tr>"
                        + "                                    <td><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td align=\"center\" valign=\"middle\" style=\"padding:10px\"><a href=\"https://1AAMN.trk.elasticemail.com/tracking/click?d=v9urDqX0RkhZcYnw4YfwltO29HASC6uNxEvRR2Xi-LUry_kBM8WTEOSU5aTb_3oYzJrSuc4WSFxtlNhs44pkFCFPIisUSxC7zpvww3ZpwOGNQa9oq4BGntjZ9jaGcE9EdcfRbeplXgc3EejbmsDO3b41\" style=\"color:#ffc82c;font-size:12px;font-family:Helvetica,Arial,sans-serif\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://1AAMN.trk.elasticemail.com/tracking/click?d%3Dv9urDqX0RkhZcYnw4YfwltO29HASC6uNxEvRR2Xi-LUry_kBM8WTEOSU5aTb_3oYzJrSuc4WSFxtlNhs44pkFCFPIisUSxC7zpvww3ZpwOGNQa9oq4BGntjZ9jaGcE9EdcfRbeplXgc3EejbmsDO3b41&amp;source=gmail&amp;ust=1687855131080000&amp;usg=AOvVaw3HKjnNTFhX3WLOARK7AdxV\"><img src=\"https://ci6.googleusercontent.com/proxy/Rjo_yMZsbTwkiWFRCd5iDb49wQtYIJbHJVl5LMU8lsfcUrBZB2vCWM51gugOGNeCQ3TX-gu73ndt2RX-L1MD5yqnwzezTSIzi36VO5Yb5lpc6a6ywvPbX--RHxZIiDdVH7u5yUmOfFa15HbDbVvarEGAq66IwZ8=s0-d-e1-ft#https://api.elasticemail.com/userfile/a18de9fc-4724-42f2-b203-4992ceddc1de/ro_sol_co_32_facebook.png\" style=\"display:block;width:32px;max-width:32px;border:none\" alt=\"Facebook\" class=\"CToWUd\" data-bit=\"iit\"></a></td></tr></tbody></table><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td align=\"center\" valign=\"middle\" style=\"padding:10px\"><a href=\"https://1AAMN.trk.elasticemail.com/tracking/click?d=jtMqoU6QZptCkh8T2q7oW_Y6Of8tVnAvp4DXCuxirg_Dasjd2uocdzFG9j2pZ8g4GcCH_PbNPqy8JM7xLud4SRUmEC6E1gjJ_yGVCtf-FMvYcDaVG2R1mQ6OJRgmev1VIZ9iXmx6jPA6APEuXfoylK0KqsDluZGQOV3DWGhBOTX3DJS-PDA-870D0x5O9skz0iUPFinIW1qxvOAKfHZaQmy_LfJsskHpIBthZq8OqfF9zHkRk9S2lqX_WUmOPb8tVA2\" style=\"color:#ffc82c;font-size:12px;font-family:Helvetica,Arial,sans-serif\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://1AAMN.trk.elasticemail.com/tracking/click?d%3DjtMqoU6QZptCkh8T2q7oW_Y6Of8tVnAvp4DXCuxirg_Dasjd2uocdzFG9j2pZ8g4GcCH_PbNPqy8JM7xLud4SRUmEC6E1gjJ_yGVCtf-FMvYcDaVG2R1mQ6OJRgmev1VIZ9iXmx6jPA6APEuXfoylK0KqsDluZGQOV3DWGhBOTX3DJS-PDA-870D0x5O9skz0iUPFinIW1qxvOAKfHZaQmy_LfJsskHpIBthZq8OqfF9zHkRk9S2lqX_WUmOPb8tVA2&amp;source=gmail&amp;ust=1687855131080000&amp;usg=AOvVaw2iiyIw4AwNxPtXsXjlHQL3\"><img src=\"https://ci4.googleusercontent.com/proxy/YVtDKNgzQ0j4A8aIezzH5EAKeazG4BSC40YRQcWsq803-sifIVbshRO5OVrVoWpxwshQcpyZcCvZ8tC0Ex4XPcMm6eVbeAzkGra1dCK_6re-2GyW59OmrdIDf9xkOLpTEFU6QzW-3dcOkGxvDTCLMqm-6XSv73TF=s0-d-e1-ft#https://api.elasticemail.com/userfile/a18de9fc-4724-42f2-b203-4992ceddc1de/ro_sol_co_32_instagram.png\" style=\"display:block;width:32px;max-width:32px;border:none\" alt=\"Instagram\" class=\"CToWUd\" data-bit=\"iit\"></a></td></tr></tbody></table></td>"
                        + "                                  </tr>"
                        + "                                </tbody>"
                        + "                              </table>"
                        + "                            </td>"
                        + "                          </tr>"
                        + "                        </tbody>"
                        + "                      </table>"
                        + "                    </div>"
                        + "                    "
                        + "                  </td>"
                        + "                </tr>"
                        + "                "
                        + "              </tbody>"
                        + "            </table>"
                        + "            "
                        + "          </td>"
                        + "        </tr>"
                        + "      </tbody>"
                        + "    </table>"
                        + "  <img src=\"https://ci3.googleusercontent.com/proxy/sK8b_kpbvycyZYU9-iP8lphRlqrxoOoWBO0pveGcquJa3TFSz8ROmVH3UqwgWYdK5XA73naVEIbGt3rh-CCuFgeSfmA6SAbL7-1bKlDVR5dgoqyo0-J9Zo_-TtjKbPl6VRU66YI=s0-d-e1-ft#https://1AAMN.trk.elasticemail.com/tracking/open?msgid=qCkbOqleKCNDGYm30VXEBg2&amp;c=0\" style=\"width:1px;height:1px\" alt=\"\" class=\"CToWUd\" data-bit=\"iit\"><div style=\"text-align:center;background-color:#fff;padding-top:10px;padding-bottom:10px;font-size:8pt;font-family:sans-serif\"><a href=\"https://1AAMN.trk.elasticemail.com/tracking/unsubscribe?d=XVeuJtkgpJ9URIle5kTUHX95VuZmbRe7zXI7pwht7jeEEzGdjebfuoZIyCDKBMW8uRCGqLyz3KYs2fBkm6-1zD0R0SLxJlbmQcyyaTNu1nwj0\" style=\"text-align:center;text-decoration:none;color:#666\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://1AAMN.trk.elasticemail.com/tracking/unsubscribe?d%3DXVeuJtkgpJ9URIle5kTUHX95VuZmbRe7zXI7pwht7jeEEzGdjebfuoZIyCDKBMW8uRCGqLyz3KYs2fBkm6-1zD0R0SLxJlbmQcyyaTNu1nwj0&amp;source=gmail&amp;ust=1687855131080000&amp;usg=AOvVaw3lz13T8ls9DGxCe9VnBxo1\">UNSUBSCRIBE</a></div></div><u></u><u></u></div>", "text/html");

                // Send message
                Transport.send(message);
                System.out.println("Sent message successfully....");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }

            if (checkValidation) {
                AccountDTO userAccount = new AccountDTO(email, password);
                UserDTO user = new UserDTO(userName, phoneNumber, roleID, address);
                boolean checkInsertAccount = dao.insertAccout(userAccount);
                dao = new AccountDAO();
                int newAccountID = dao.getNewAccountID();
                boolean checkInsertUser = dao.insertUser(user);
                user.setUserID(dao.getUserByAccountID(newAccountID).getUserID());
                if (checkInsertAccount && checkInsertUser) {
                    url = SUCCESS;
                    UserGoogleDTO accountGoogle = (UserGoogleDTO) session.getAttribute("LOGIN_ACCOUNT");
                    if (accountGoogle != null) {
                        session.setAttribute("LOGIN_USER", user);
                    }
                } else {
                    userError.setError("Unknow user");
                    request.setAttribute("USER_ERROR", userError);
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            log("Error at RegisterController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

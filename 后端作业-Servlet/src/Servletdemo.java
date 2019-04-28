import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

class AccountBean {
    private String username = "";
    private String password = "";
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
public class Servletdemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        AccountBean account = new AccountBean();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        account.setPassword(password);
        account.setUsername(username);
        if ((username != null) && (username.trim().equals("admin"))) {
            if ((password != null) && (password.trim().equals("123456"))) {
                System.out.println("success");
                session.setAttribute("account", account);
                String login_suc = "success.jsp";
                response.sendRedirect(login_suc);
                return;
            }
        }
        String login_fail = "false.jsp";
        response.sendRedirect(login_fail);
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.*;


// Doing it in ScheduledExecutorService
// https://stackoverflow.com/questions/20387881/how-to-run-certain-task-every-day-at-a-particular-time-using-scheduledexecutorse
@WebServlet(value="/scheduled-task", loadOnStartup=1)
public class ScheduleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	Timer timer = new Timer();
	MyTimerTask task = new MyTimerTask();

	@Override
	public void init() throws ServletException {
		timer.scheduleAtFixedRate(task, 0, 3000 );
	}
	
	@Override
	public void destroy() {
		timer.cancel();
	}

}

class MyTimerTask extends TimerTask {
	
	@Override
	public void run() {
		System.out.println("Ring ring..");
	}
	
}

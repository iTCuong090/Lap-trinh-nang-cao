import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Lớp đại diện cho Yêu cầu hỗ trợ (Ticket)
class Ticket {
    private String id;
    private String content;
    private long timestamp;

    public Ticket(String id, String content, long timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }
}

// Lớp đại diện cho Khách hàng (Customer)
class Customer {
    private String id;
    private String name;
    private Ticket ticket;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    //Hàm xử lý đại diện cho hành động của khách hàng (tạo ticket).
    public void createTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}

// Lớp đại diện cho Tin nhắn (Message)
class Message {
    private String id;
    private String content;

    public Message(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Lớp Quản lý Hệ thống hỗ trợ
public class SupportSystem {
    // Queue: Hoạt động theo cơ chế FIFO (Vào trước ra trước)
    private Queue<Customer> customerQueue;
    // Stack: Hoạt động theo cơ chế LIFO (Vào sau ra trước)
    private Stack<Message> messageHistory;

    public SupportSystem() {
        this.customerQueue = new LinkedList<>();
        this.messageHistory = new Stack<>();
    }

    // 1. Chức năng Hàng đợi khách hàng
    public void addCustomer(Customer customer) {
        customerQueue.offer(customer); // Thêm vào cuối hàng đợi
        System.out.println("[Queue] Khách hàng " + customer.getName() + " đã tham gia hàng đợi.");
    }

    public void processNextCustomer() {
        System.out.println("\n--------------------------------------------------");
        if (customerQueue.isEmpty()) {
            System.out.println("[Queue] Không còn khách đợi.");
            return;
        }
        
        Customer customer = customerQueue.poll(); // Lấy ra từ đầu hàng đợi
        System.out.println("[Queue] Đang xử lý cho khách hàng: " + customer.getName());
        System.out.println("        Lý do: " + customer.getTicket().getContent());
        
        // Làm mới lịch sử tin nhắn khi chuyển sang khách hàng mới
        messageHistory.clear(); 
    }

    // 2. Chức năng Lịch sử tin nhắn
    public void typeMessage(Message msg) {
        messageHistory.push(msg); // Lưu vào đỉnh Stack
        System.out.println("[Stack] Nhân viên gõ: \"" + msg.getContent() + "\"");
    }

    public void viewLastMessage() {
        if (!messageHistory.isEmpty()) {
            // Peek: Xem phần tử trên cùng mà không xóa
            System.out.println("[Stack] View Last (Câu vừa gõ): \"" + messageHistory.peek().getContent() + "\"");
        } else {
            System.out.println("[Stack] Không có tin nhắn nào trong lịch sử.");
        }
    }

    public void undoMessage() {
        if (!messageHistory.isEmpty()) {
            // Pop: Lấy ra và xóa phần tử trên cùng của Stack
            Message removedMsg = messageHistory.pop();
            System.out.println("[Stack] Đã Undo (xóa) câu: \"" + removedMsg.getContent() + "\"");
        } else {
            System.out.println("[Stack] Lịch sử trống, không thể Undo.");
        }
    }
}

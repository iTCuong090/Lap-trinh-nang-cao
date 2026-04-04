// Lớp Main để chạy giả lập kịch bản
public class Main {
    public static void main(String[] args) {
        SupportSystem system = new SupportSystem();

        System.out.println("=== HỆ THỐNG HỖ TRỢ KHÁCH HÀNG ===");

        // Tạo dữ liệu giả lập
        Customer customerA = new Customer("C01", "Khách A");
        Ticket ticketA = new Ticket("T01", "Đơn hàng của tôi bị giao chậm", System.currentTimeMillis());
        customerA.createTicket(ticketA);

        
        Customer customerB = new Customer("C02", "Khách B");
        Ticket ticketB = new Ticket("T02", "Tôi muốn đổi trả sản phẩm", System.currentTimeMillis());
        customerB.createTicket(ticketB);


        // KỊCH BẢN GIẢ LẬP:
        // Khách A và Khách B lần lượt đến
        system.addCustomer(customerA);
        system.addCustomer(customerB);

        // Xử lý khách A
        system.processNextCustomer();
        
        // Nhân viên gõ 3 dòng tin nhắn cho A
        system.typeMessage(new Message("M1", "Chào bạn, Tiki/Shopee xin nghe."));
        system.typeMessage(new Message("M2", "Tôi đang kiểm tra trạng thái đơn hàng của bạn."));
        system.typeMessage(new Message("M3", "Đơn hàng của bạn đã bị mất cmnr.")); // Gõ sai/lỗi

        // Nhân viên kiểm tra lại câu vừa gõ
        system.viewLastMessage();

        // Nhân viên phát hiện gõ sai -> Bấm Undo 1 dòng
        system.undoMessage();
        
        // Nhân viên gõ lại câu đúng
        system.typeMessage(new Message("M4", "Đơn hàng đang ở kho phân loại, sẽ giao trong ngày mai ạ."));

        // Xử lý khách B
        system.processNextCustomer();
        system.typeMessage(new Message("M5", "Chào bạn, vui lòng cung cấp mã đơn hàng để hỗ trợ đổi trả."));

        // Thử xử lý tiếp khi hàng đợi đã rỗng
        system.processNextCustomer();
    }
}
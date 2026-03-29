public class Main {
    public static void main(String[] args) {
        /*
        // --- PHẦN CODE LỖI ---
        interface IData {  void show(); }
        // Mặc định là public abstract    
        class DataManager implements IData {  
            // Cố tình KHÔNG ghi public  
            void show() {  System.out.println("Show Data");  }  
        } 
        */

        System.out.println("Trước khi sửa: ");
        
        // Fix chuỗi String: Dùng \n để xuống dòng và \" để in dấu ngoặc kép
        System.out.println("Main.java:7: error: show() in DataManager cannot implement show() in IData\n" +
                "        void show() {  System.out.println(\"Show Data\");  }  \n" +
                "             ^\n" +
                "  attempting to assign weaker access privileges; was public\n" +
                "1 error\n");

        System.out.println("Sau khi sửa: ");

        interface IData {  void show(); }
        // Mặc định là public abstract    
        class DataManager implements IData {  
            // Bắt buộc phải ghi public vì ở hợp đồng Interface mặc định hàm là public.  
            public void show() {  System.out.println("Show Data");  }  
        } 

        DataManager dm = new DataManager();
        dm.show();
    }
}
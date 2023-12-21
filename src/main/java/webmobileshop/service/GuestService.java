package webmobileshop.service;

import java.util.List;
import webmobileshop.dto.GuestDTO;;

public interface GuestService {
	//đưa ra tất cả các dữ liệu trong bảng Quest
	List<GuestDTO> getAllGuest();
	//đưa ra dữ liệu theo id của 1 phần tử trong bảng Quest
	GuestDTO getByQuestId(String questId);
	// đưa ra dữ liệu của các phần tử theo tên đăng nhập
	List<GuestDTO> getByquestName(String questName);
	// đưa ra dữ liệu của các phần tử theo địa chỉ 
	List<GuestDTO> getByquestAddress(String questAddress);
	// đưa ra dữ liệu của các phần tử theo Email
	List<GuestDTO> getByquestEmail(String questEmail);
	// đưa ra dữ liệu của các phần tử theo số điện thoại
	List<GuestDTO> getByquestPhone(String questPhone);
	// đưa ra dữ liệu của các phần tử theo họ
	List<GuestDTO> getByfistName(String fristName);
	// đưa ra dữ liệu của các phần tử theo tên
	List<GuestDTO> getBylastName(String lastName);
	// tạo một phần tử mới trong bảng Quest
	void createGuest(GuestDTO guestDTO);
	//cập nhập dữ liệu của một phần tử trong Database
	void updateGuest(GuestDTO guestDTO);
	//xóa một phần tử được chỉ định trong bảng Quest
	void deleteGuest(String questId);
}

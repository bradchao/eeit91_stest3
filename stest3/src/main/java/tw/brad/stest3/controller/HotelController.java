package tw.brad.stest3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.brad.stest3.model.Hotel;
import tw.brad.stest3.repository.HotelRepository;

@RequestMapping("/hotel")
@RestController
public class HotelController {

	@Autowired
	private HotelRepository hotelRepository;
	
	@PostMapping("/test1")
	public void test1() {
		List<Hotel> list = hotelRepository.findByName("飛牛牧場休閒農場");
		System.out.println(list.size());
		System.out.println(list.get(0).getAddr());
	}
	
	@PostMapping("/test2")
	public void test2() {
		List<Hotel> list = hotelRepository.findByAddrStartingWith("台南");
		System.out.println(list.size());
		for (Hotel hotel : list) {
			System.out.printf("%s : %s\n", hotel.getName(), hotel.getAddr());
		}
	}
	
	@PostMapping("/test3")
	public void test3() {
		List<Hotel> list = hotelRepository.findByNameEndingWith("民宿");
		System.out.println(list.size());
		for (Hotel hotel : list) {
			System.out.printf("%s : %s\n", hotel.getName(), hotel.getAddr());
		}
	}	
	
	@PostMapping("/test4")
	public void test4() {
		List<Hotel> list = hotelRepository.findByNameEndingWith("農場");
		System.out.println(list.size());
		for (Hotel hotel : list) {
			System.out.printf("%s : %s\n", hotel.getName(), hotel.getAddr());
		}
	}	

	@PostMapping("/test5")
	public void test5() {
		List<Hotel> list = hotelRepository.findByNameContaining("農場");
		System.out.println(list.size());
		for (Hotel hotel : list) {
			System.out.printf("%s : %s\n", hotel.getName(), hotel.getAddr());
		}
	}	
	
	@PostMapping("/test6")
	public void test6() {
		List<Hotel> list = hotelRepository.findByNameLike("%農場%");
		System.out.println(list.size());
		for (Hotel hotel : list) {
			System.out.printf("%s : %s\n", hotel.getName(), hotel.getAddr());
		}
	}	
	
	@PostMapping("/test7")
	public void test7() {
		List<Hotel> list = hotelRepository.findByNameLikeOrAddrContaining("%民宿%", "池上");
		System.out.println(list.size());
		for (Hotel hotel : list) {
			System.out.printf("%s : %s\n", hotel.getName(), hotel.getAddr());
		}
	}	

	@PostMapping("/test8")
	public void test8() {
		List<Hotel> list = hotelRepository.find1(74);
		System.out.println(list.size());
		for (Hotel hotel : list) {
			System.out.printf("%d: %s : %s\n", hotel.getId(), hotel.getName(), hotel.getAddr());
		}
	}	

	@GetMapping("/test9/{nums}/{page}/{isAsc}")
	public Page<Hotel> test9(@PathVariable Integer page,
				@PathVariable Integer nums, @PathVariable Boolean isAsc) {
		String sortBy = "addr";
		Sort sortAsc = Sort.by(sortBy).ascending();
		Sort sortDesc = Sort.by(sortBy).descending();
		
		Pageable pagable = PageRequest.of(page-1, nums, isAsc?sortAsc:sortDesc);
		Page<Hotel> hotels = hotelRepository.findAll(pagable);
		
		return hotels;
	}	

	
}

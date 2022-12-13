package com.cybage.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cybage.model.BookingEvent;
import com.cybage.model.EventBean;
import com.cybage.model.RegistrationBean;
import com.cybage.repository.BookingEventRepository;

@Service
public class BookingEventService {
	
	@Autowired
	private BookingEventRepository bookingEventRepository;
	private JavaMailSender mailSender;

	
	public BookingEvent addBooking(BookingEvent bookingBean) //throws MessagingException 
	{

//		try {
//			sendMailToConfirmBooking(bookingBean);
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return bookingEventRepository.save(bookingBean);
		//send email method

	}
	
	public List<BookingEvent> getAllBooking()
	{
		return bookingEventRepository.findAll();	
	}
	
	public BookingEvent getBookingById(int id)
	{
		return bookingEventRepository.findById(id).orElse(null);
	}
	
	public void deleteBookingById(int id)
	{
		bookingEventRepository.deleteById(id);
	}
	
	//booking status updated by organizer
	public BookingEvent updateBookingStatus(int id, BookingEvent bookingEvent)
	{
		BookingEvent bookingEvent1 = bookingEventRepository.findById(id).get();
			if(bookingEvent.getBookingId()!=0)
				bookingEvent1.getBookingId();
			
			if(bookingEvent.getBookingStatus()!=null)
				bookingEvent1.setBookingStatus(bookingEvent.getBookingStatus());
			
		return bookingEventRepository.save(bookingEvent1);
	}
	

	public void sendMailToConfirmBooking(BookingEvent bookingEvent) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		String toAddress = bookingEvent.getEvent().getEventOrganizer().getEmail();
		String subject = "Welcome to EMS, please verify your account";

		String content = "<p> You Got a new booking request!!</p>";

		mimeMessageHelper.setFrom("Trng2@evolvingsols.com");
		mimeMessageHelper.setTo(toAddress);
		mimeMessageHelper.setText(content);
		mimeMessageHelper.setSubject(subject);

		mailSender.send(mimeMessage);

		System.out.println("Mail Send Successfully");
	}

	//booking status updated by user
	public BookingEvent updateUserStatus(int id, BookingEvent bookingEvent) 
	{
		BookingEvent bookingEvent1 = bookingEventRepository.findById(id).get();
		
		if(bookingEvent.getBookingId()!=0)
			bookingEvent1.getBookingId();
		
		if(bookingEvent.getUserBookingStatus()!=null)
			bookingEvent1.setUserBookingStatus(bookingEvent.getUserBookingStatus());
		
	return bookingEventRepository.save(bookingEvent1);
	}
	
	//get booking history list by userId
	public List<BookingEvent> bookingHistoryByUserId(int id){
		return bookingEventRepository.bookingHistoryByUserId(id);
	}
	
	//get booking list by organizer id
	public List<BookingEvent> getBookingHistoryByOrganizerId(int id){
		return bookingEventRepository.getBookingHistoryByOrganizerId(id);
	}
}
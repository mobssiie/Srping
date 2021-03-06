package ui;

import model.Reservation;

import org.apache.commons.lang.StringUtils;

import dao.ReservationDao;

public class DeleteReservationUi extends AbstractUi {

	private ReservationDao reservationDao;
	
	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}
	
	public void show() {
		
		// 헤더를 표시
		showHeader();
		
		// 콘솔에서 입려된 값을 취득
		Integer reservationId = getReservationId();
		if (reservationId == null) {
			return;
		}
		
		// ID로 예약을 검색
		Reservation reservation = this.reservationDao.getReservation(reservationId);
		if (reservation == null) {
			// 해당하는 예약은 존재하지 않는다.
			System.out.println("입력된 ID에 해당하는 예약은 존재하지 않습니다.");
			show();
		}
		
		// 예약을 취소
		this.reservationDao.cancelReservation(reservation);
		System.out.printf("ID가 '%s'인 예약을 취소했습니다. %n", reservationId);
	}
	
	protected Integer getReservationId() {
		// 콘솔에서 입력된 값을 취득
		String reservationId = getInputedString();
		// 문자열이 입력되어 있는지?
		if (StringUtils.isBlank(reservationId)) {
			return null;
		}
		// 숫자인지?
		if (StringUtils.isNumeric(reservationId)) {
			return Integer.valueOf(reservationId);
		}
		System.out.println("ID는 숫자로 입력해 주세요.");
		
		return getReservationId();
	}
	
	protected void showHeader() {
		System.out.println("----------------------");
		System.out.println("[티켓 예약][예약 취소]");
		System.out.println("");
		System.out.println("예약을 취소할 티켓의 ID를 입력한 후 Enter를 눌러주세요.");
		System.out.println("아무것도 입력하지 않고 Enter를 누르면 메뉴로 돌오갑니다.");
	}
}
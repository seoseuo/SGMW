document.addEventListener('DOMContentLoaded', () => {
	const form = document.getElementById('professorEditMyClassGrade');
	let focusSet = false; // 커서 이동을 한 번만 실행하도록 설정

	// 폼을 제출하기 전에 데이터 입력 유효성 검사를 하기 위함.
	form.addEventListener('submit', (event) => {

		// 유효성 검사 결과를 저장할 변수
		let isValid = true;

		
		// 중간고사 유효성 검사
		const midterm = form.elements['middleGrade'].value;
		const midtermWarn = document.getElementById('middleGrade_warn');
		const midtermCursor = document.getElementById("middleGrade");
		if (midterm === '') {
			midtermWarn.textContent = '* 점수를 입력하세요.';
			isValid = false;
			if (!focusSet) {
				midtermCursor.focus();
				focusSet = true;
			}
		} else if (!/^\d+$/.test(midterm)) {
			midtermWarn.textContent = '* 양의 정수여야 합니다.';
			isValid = false;
			if (!focusSet) {
				midtermCursor.focus();
				focusSet = true;
			}
		} else if (midterm < 0 || midterm > 100) {
			midtermWarn.textContent = '* 0에서 100 사이여야 합니다.';
			isValid = false;
			if (!focusSet) {
				midtermCursor.focus();
				focusSet = true;
			}
		} else {
			midtermWarn.textContent = ''; // 경고 메시지 초기화
		}

		// 기말고사 유효성 검사
		const finalExam = form.elements['finalGrade'].value;
		const finalWarn = document.getElementById('finalGrade_warn');
		const finalCursor = document.getElementById("finalGrade");
		if (finalExam === '') {
			finalWarn.textContent = '* 점수를 입력하세요.';
			isValid = false;
			if (!focusSet) {
				finalCursor.focus();
				focusSet = true;
			}
		} else if (!/^\d+$/.test(finalExam)) {
			finalWarn.textContent = '* 양의 정수여야 합니다.';
			isValid = false;
			if (!focusSet) {
				finalCursor.focus();
				focusSet = true;
			}
		} else if (finalExam < 0 || finalExam > 100) {
			finalWarn.textContent = '* 0에서 100 사이여야 합니다.';
			isValid = false;
			if (!focusSet) {
				finalCursor.focus();
				focusSet = true;
			}
		} else {
			finalWarn.textContent = ''; // 경고 메시지 초기화
		}

		// 유효성 검사 실패 시 폼 제출 방지
		if (!isValid) {
			event.preventDefault(); // 폼 제출 방지
		}
	});
});

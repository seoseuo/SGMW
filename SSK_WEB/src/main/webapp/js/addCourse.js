document.addEventListener('DOMContentLoaded', () => {
	const form = document.getElementById('addCourse');
	let focusSet = false; // 커서 이동을 한 번만 실행하도록 설정

	form.addEventListener('submit', (event) => {
		let isValid = true; // 유효성 검사 결과를 저장할 변수

		// 이름 유효성 검사
		const name = form.elements['name'].value;
		const nameWarn = document.getElementById('name_warn');
		const nameCursor = document.getElementById("name");

		if (name === '') {
			nameWarn.textContent = '* 강의를 입력하세요.';
			isValid = false;
			if (!focusSet) {
				nameCursor.focus();
				focusSet = true;
			}
		}
		// 앞뒤로 공백이 있을 때 경고 메시지
		else if (name !== name.trim()) {
			nameWarn.textContent = '* 이름의 앞뒤는 공백이 없어야 합니다.';
			isValid = false;
			if (!focusSet) {
				nameCursor.focus(); // 포커스를 이름 입력 필드로 이동
				focusSet = true;
			}
		}
		// 한글과 공백을 허용하는 정규 표현식
		else if (!/^[가-힣\s]+$/.test(name)) {
			nameWarn.textContent = '* 이름은 올바른 한글만 입력 가능합니다.';
			isValid = false;
			if (!focusSet) {
				nameCursor.focus(); // 포커스를 이름 입력 필드로 이동
				focusSet = true;
			}
		}
		else {
			nameWarn.textContent = ''; // 경고 메시지 초기화
		}

		// 학점 유효성 검사
		const point = form.elements['point'].value;
		const pointWarn = document.getElementById('point_warn');
		const pointCursor = document.getElementById("point");

		if (point === '') {
			pointWarn.textContent = '* 학점을 입력하세요.';
			isValid = false;
			if (!focusSet) {
				pointCursor.focus();
				focusSet = true;
			}
		} else if (!/^[1-9]\d*$/.test(point)) {
			pointWarn.textContent = '* 학점은 양의 정수여야 합니다.';
			isValid = false;
			if (!focusSet) {
				pointCursor.focus();
				focusSet = true;
			}
		} else if (point < 1 || point > 3) {
			pointWarn.textContent = '* 학점은 1부터 3까지여야 합니다.';
			isValid = false;
			if (!focusSet) {
				pointCursor.focus();
				focusSet = true;
			}
		} else {
			pointWarn.textContent = ''; // 경고 메시지 초기화
		}

		// 유효성 검사 실패 시 폼 제출 방지
		if (!isValid) {
			event.preventDefault(); // 폼 제출 방지
		}
	});
});

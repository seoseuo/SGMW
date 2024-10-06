document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('professorEditCourseGrade');
    let focusSet = false;

    form.addEventListener('submit', (event) => {
        let isValid = true;

        // 모든 입력 필드에 대해 유효성 검사 수행
        const midtermInputs = form.querySelectorAll('input[name^="middleGrade_"]');
        const finalInputs = form.querySelectorAll('input[name^="finalGrade_"]');

        midtermInputs.forEach(midtermInput => {
            const midterm = midtermInput.value;
            const midtermWarn = document.getElementById(`middleGrade_warn_${midtermInput.name.split('_')[1]}`);
            if (midterm === '') {
                midtermWarn.textContent = '* 점수를 입력하세요.';
                isValid = false;
                if (!focusSet) {
                    midtermInput.focus();
                    focusSet = true;
                }
            } else if (!/^\d+$/.test(midterm)) {
                midtermWarn.textContent = '* 양의 정수여야 합니다.';
                isValid = false;
                if (!focusSet) {
                    midtermInput.focus();
                    focusSet = true;
                }
            } else if (midterm < 0 || midterm > 100) {
                midtermWarn.textContent = '* 0이상 100 이하여야 합니다.';
                isValid = false;
                if (!focusSet) {
                    midtermInput.focus();
                    focusSet = true;
                }
            } else {
                midtermWarn.textContent = ''; // 경고 메시지 초기화
            }
        });

        finalInputs.forEach(finalInput => {
            const finalExam = finalInput.value;
            const finalWarn = document.getElementById(`finalGrade_warn_${finalInput.name.split('_')[1]}`);
            if (finalExam === '') {
                finalWarn.textContent = '* 점수를 입력하세요.';
                isValid = false;
                if (!focusSet) {
                    finalInput.focus();
                    focusSet = true;
                }
            } else if (!/^\d+$/.test(finalExam)) {
                finalWarn.textContent = '* 양의 정수여야 합니다.';
                isValid = false;
                if (!focusSet) {
                    finalInput.focus();
                    focusSet = true;
                }
            } else if (finalExam < 0 || finalExam > 100) {
                finalWarn.textContent = '* 0이상 100 이하여야 합니다.';
                isValid = false;
                if (!focusSet) {
                    finalInput.focus();
                    focusSet = true;
                }
            } else {
                finalWarn.textContent = ''; // 경고 메시지 초기화
            }
        });

        // 유효성 검사 실패 시 폼 제출 방지
        if (!isValid) {
            event.preventDefault();
        }
    });
});

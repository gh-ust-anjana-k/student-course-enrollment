const BASE_URL = "http://localhost:8080";

// ---------------- COURSES ----------------
function loadCourses() {
    fetch(`${BASE_URL}/courses`)
        .then(res => res.json())
        .then(data => {
            const courseList = document.getElementById("courseList");
            const courseSelect = document.getElementById("courseSelect");

            if (courseList) courseList.innerHTML = "";
            if (courseSelect) courseSelect.innerHTML = `<option value="">Select Course</option>`;

            data.forEach(course => {
                // Course cards (for index.html)
                if (courseList) {
                    const card = document.createElement("div");
                    card.className = "card";
                    card.innerHTML = `
                        <h4>${course.courseName}</h4>
                        <p><b>Instructor:</b> ${course.instructor}</p>
                        <p><b>Duration:</b> ${course.duration}</p>
                    `;
                    courseList.appendChild(card);
                }

                // Dropdown (for enroll.html)
                if (courseSelect) {
                    const option = document.createElement("option");
                    option.value = course.courseId || course.id || index; // Fallback if courseId is missing
                    console.log("Creating option with value:", option.value, "course data:", course);
                    option.textContent = course.courseName; // show course name in dropdown
                    courseSelect.appendChild(option);
                }
            });
        });
}

// ---------------- ENROLLMENTS TABLE ----------------
function loadEnrollments() {
    fetch(`${BASE_URL}/enrollments`)
        .then(res => res.json())
        .then(data => {
            const table = document.getElementById("enrollmentTable");
            if (!table) return;

            table.innerHTML = "";

            data.forEach(e => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${e.enrollmentId}</td>
                    <td>${e.studentName}</td>
                    <td>${e.courseId}</td>
                    <td>${e.status}</td>
                `;
                table.appendChild(row);
            });
        });
}

// ---------------- ADD NEW ENROLLMENT ----------------
function addEnrollment(studentName, courseId) {
    console.log("addEnrollment called with:", { studentName, courseId });
    
    // Validate inputs
    if (!studentName || !courseId) {
        alert("Please fill in all fields");
        console.log("Validation failed - empty fields");
        return;
    }

    // Get the course name from the selected option
    const courseSelect = document.getElementById("courseSelect");
    console.log("courseSelect element:", courseSelect);
    console.log("courseSelect options:", courseSelect.options);
    console.log("courseSelect.selectedIndex:", courseSelect.selectedIndex);
    
    const courseName = courseSelect.options[courseSelect.selectedIndex].text;
    console.log("Selected course name:", courseName);
    console.log("courseId before parseInt:", courseId, "type:", typeof courseId);

    const parsedCourseId = parseInt(courseId);
    console.log("courseId after parseInt:", parsedCourseId, "isNaN?", isNaN(parsedCourseId));

    const payload = { 
        studentName, 
        courseId: parsedCourseId,
        courseName: courseName
    };

    console.log("Sending payload:", payload);

    fetch(`${BASE_URL}/enrollments`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload)
    })
    .then(res => {
        console.log("Response status:", res.status);
        if (!res.ok) {
            return res.text().then(text => {
                throw new Error(`HTTP ${res.status}: ${text}`);
            });
        }
        return res.json();
    })
    .then(data => {
        console.log("Success response:", data);
        alert(`Enrollment successful! ID: ${data.enrollmentId}`);

        // Append to table on enroll.html immediately
        const table = document.getElementById("recentEnrollments");
        if (table) {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${data.enrollmentId}</td>
                <td>${data.studentName}</td>
                <td>${data.courseId}</td>
                <td>${data.status}</td>
            `;
            table.appendChild(row);
        }

        document.getElementById("enrollmentForm").reset();
    })
    .catch(err => {
        console.error("Full error:", err);
        alert("Enrollment failed: " + err.message);
    });
}

// ---------------- FORM SUBMIT ----------------
document.addEventListener("DOMContentLoaded", () => {
    loadCourses();

    const form = document.getElementById("enrollmentForm");
    if (form) {
        form.addEventListener("submit", e => {
            e.preventDefault();
            const studentName = document.getElementById("studentName").value;
            const courseId = document.getElementById("courseSelect").value;
            addEnrollment(studentName, courseId);
        });
    }
});

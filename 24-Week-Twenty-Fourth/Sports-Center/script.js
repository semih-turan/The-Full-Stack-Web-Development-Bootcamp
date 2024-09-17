// Scroll event to handle navigation bar styling on scroll
window.addEventListener('scroll', function() {
    var navigation = document.querySelector('.navigation');
    
    // Add 'scrolled' class if page is scrolled more than 50px, otherwise remove it
    if (window.scrollY > 50) {
        navigation.classList.add('scrolled');
    } else {
        navigation.classList.remove('scrolled');
    }
});

// DOMContentLoaded event to ensure the DOM is fully loaded before executing scripts
document.addEventListener("DOMContentLoaded", function() {
    const navbar = document.querySelector('.navigation');
    const navbarHeight = navbar.offsetHeight; // Get the height of the navigation bar
    
    // Add click event to all navigation links for smooth scrolling
    document.querySelectorAll('.nav-links a').forEach(anchor => {
        anchor.addEventListener('click', function(e) {
            e.preventDefault(); // Prevent default link behavior
            
            // Get the target section's ID from the clicked link's href attribute
            const targetId = this.getAttribute('href').substring(1);
            const targetElement = document.getElementById(targetId);
            
            // Calculate the scroll position considering the navbar height
            const elementPosition = targetElement.getBoundingClientRect().top;
            const offsetPosition = elementPosition - navbarHeight;
            
            // Smoothly scroll to the target position
            window.scrollBy({
                top: offsetPosition,
                behavior: 'smooth'
            });
        });
    });
});

// Window onload event to handle mobile menu and additional scroll behavior
window.onload = function () {
    const menuBtn = document.querySelector('.hamburger');
    const mobileMenu = document.querySelector('.mobile-nav');
    const nav = document.querySelector('.navigation');

    // Change navigation background color on scroll
    window.onscroll = function () {
        if (document.body.scrollTop >= 50 || document.documentElement.scrollTop >= 50) {
            nav.style.backgroundColor = "rgb(53, 85, 146)";
            nav.style.transition = "0.5s";
            nav.style.width = "100%";
        } else {
            nav.style.backgroundColor = "rgba(53, 85, 146, 0)";
        }
    };

    // Toggle the mobile menu visibility when the hamburger menu is clicked
    menuBtn.addEventListener('click', () => {
        menuBtn.classList.toggle('is-active');
        mobileMenu.classList.toggle('is-active');
    });

    // Close the mobile menu when a link inside it is clicked
    mobileMenu.addEventListener('click', (e) => {
        if (e.target.tagName === 'A') {
            menuBtn.classList.remove('is-active');
            mobileMenu.classList.remove('is-active');
        }
    });
};

// Function to calculate Body Mass Index (BMI) based on user input
function calculateBMI() {
    const height = parseFloat(document.getElementById('height').value) / 100; // Convert height to meters
    const weight = parseFloat(document.getElementById('weight').value); // Get weight in kilograms
    
    // If both height and weight are valid, calculate BMI
    if (height && weight) {
        const bmi = (weight / (height * height)).toFixed(2); // Calculate BMI and round to two decimal places
        document.getElementById('result').textContent = `Your BMI: ${bmi}`; // Display the BMI result
        updateArrowPosition(bmi); // Update the position of the arrow on the BMI scale
    }
}

// Function to update the position of the arrow on the BMI scale based on BMI value
function updateArrowPosition(bmi) {
    const arrow = document.getElementById('bmi-arrow'); // Get the arrow element
    const bmiImg = document.querySelector('.bmi-img img'); // Get the BMI scale image
    
    // Calculate the image width and scale factor
    const imgWidth = bmiImg.clientWidth;
    const scaleFactor = imgWidth / 600; // Original image width is 600px
    const baseOffset = 115; // Base offset for the starting position of the arrow

    let leftPosition;

    // Determine the arrow position based on the BMI value within different ranges

    // First range: BMI < 18.5 (Underweight)
    if (bmi < 18.5) {
        const minPos = baseOffset + (54.03 * scaleFactor);
        const maxPos = baseOffset + (143.42 * scaleFactor);
        leftPosition = (minPos + maxPos) / 2;

    // Second range: 18.5 <= BMI < 24.9 (Normal weight)
    } else if (bmi >= 18.5 && bmi < 24.9) {
        const minPos = baseOffset + (152.59 * scaleFactor);
        const maxPos = baseOffset + (242.07 * scaleFactor);
        leftPosition = minPos + (bmi - 18.5) * ((maxPos - minPos) / (24.9 - 18.5));

    // Third range: 25 <= BMI < 29.9 (Overweight)
    } else if (bmi >= 25 && bmi < 29.9) {
        const minPos = baseOffset + (251.59 * scaleFactor);
        const maxPos = baseOffset + (341.07 * scaleFactor);
        leftPosition = minPos + (bmi - 25) * ((maxPos - minPos) / (29.9 - 25));

    // Fourth range: 30 <= BMI < 34.9 (Obesity I)
    } else if (bmi >= 30 && bmi < 34.9) {
        const minPos = baseOffset + (349.28 * scaleFactor);
        const maxPos = baseOffset + (439.63 * scaleFactor);
        leftPosition = minPos + (bmi - 30) * ((maxPos - minPos) / (34.9 - 30));

    // Final range: BMI >= 35 (Obesity II and above)
    } else if (bmi >= 35) {
        const minPos = baseOffset + (447.84 * scaleFactor);
        const maxPos = baseOffset + (537.75 * scaleFactor);
        leftPosition = (minPos + maxPos) / 2;
    }

    // Ensure the arrow position stays within the image boundaries
    leftPosition = Math.max(leftPosition, 0);
    leftPosition = Math.min(leftPosition, imgWidth);

    // Set the left position of the arrow and make it visible
    arrow.style.left = `${leftPosition}px`;
    arrow.style.display = 'block';
}

// Event listener to update the arrow position when the window is resized
window.addEventListener('resize', () => {
    const height = parseFloat(document.getElementById('height').value) / 100;
    const weight = parseFloat(document.getElementById('weight').value);
    
    // If both height and weight are valid, recalculate the BMI and update the arrow position
    if (height && weight) {
        const bmi = (weight / (height * height)).toFixed(2);
        updateArrowPosition(bmi);
    }
});

// Add event listeners to height and weight input fields to trigger BMI calculation on input change
document.getElementById('height').addEventListener('input', calculateBMI);
document.getElementById('weight').addEventListener('input', calculateBMI);

const buttons = document.querySelectorAll("button[id^='btn']");
const contentContainer = document.querySelector(".classes-content");

const contents = {
    btn1: contentContainer.innerHTML,
    btn2: `
    <div id="btn2-content" class="classes-hero">
        <div class="info-img">
            <img src="./assets/images/group.webp" alt="">
        </div>
        <div class="info-yoga">
            <h1>Yoga with our group</h1>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Pariatur possimus voluptatum impedit odit perferen</p>
            <h1>Our group meeting hours</h1>
            <p id="week-program">Saturday-Sunday: 8:00am -10:00am <br> Monday-Tuesday: 10:00am -12:00pm <br> Wednesday-Friday: 3:00pm - 6:00pm</p> 
        </div>
    </div>`,
    btn3: `
    <div id="btn3-content" class="classes-hero">
        <div class="info-yoga">
            <h1>For those who want to work solo</h1>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Pariatur possimus voluptatum impedit odit perferendis</p>
            <h1>When comes Yoga Your Time.</h1>
            <p id="week-program">Saturday-Sunday: 8:00am -10:00am <br> Monday-Tuesday: 10:00am -12:00pm <br> Wednesday-Friday: 3:00pm - 6:00pm</p> 
        </div>
        <div class="info-img">
            <img src="./assets/images/solo.jpg" alt="">
        </div>
    </div>`,
    btn4: `
    <div id="btn4-content" class="classes-hero">
        <div class="info-img">
            <img src="./assets/images/stret.webp" alt="">
        </div>
        <div class="info-yoga">
            <h1>Streching</h1>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Pariatur possimus voluptatum impedit odit perferen</p>
            <h1>Our group meeting hours</h1>
            <p id="week-program">Saturday-Sunday: 8:00am -10:00am <br> Monday-Tuesday: 10:00am -12:00pm <br> Wednesday-Friday: 3:00pm - 6:00pm</p> 
        </div>
    </div>`
};

buttons.forEach(button => {
    button.addEventListener("click", () => {
        buttons.forEach(btn => btn.classList.remove("active"));
        button.classList.add("active");
        contentContainer.innerHTML = contents[button.id];
    });
});
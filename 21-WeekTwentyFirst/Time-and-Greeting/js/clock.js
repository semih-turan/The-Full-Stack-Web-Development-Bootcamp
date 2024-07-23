function askName() {
    const name = prompt("Adınız nedir?");
    document.getElementById("myName").innerText = name || "Misafir";
}

function showTime() {
    const date = new Date();
    const h = date.getHours().toString().padStart(2, '0');
    const m = date.getMinutes().toString().padStart(2, '0');
    const s = date.getSeconds().toString().padStart(2, '0');
    const weekdayNumber = date.getDay();

    const arrayOfWeekdays = ["Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"];
    const weekdayName = arrayOfWeekdays[weekdayNumber];

    const time = `${h}:${m}:${s} ${weekdayName}`;
    document.getElementById("myClock").innerText = time;

    setTimeout(showTime, 1000);
}

document.addEventListener("DOMContentLoaded", () => {
    askName();
    showTime();
});
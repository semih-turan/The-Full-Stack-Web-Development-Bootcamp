// Function to show a toast message
function showToast(type) {
    if (type === 'error') {
        $(".error").toast("show");
    } else if (type === 'success') {
        $(".success").toast("show");
    }
}

// Function to save tasks to localStorage
function saveTasks(tasks) {
    localStorage.setItem('tasks', JSON.stringify(tasks));
}

// Function to get tasks from localStorage
function getTasks() {
    const tasks = localStorage.getItem('tasks');
    return tasks ? JSON.parse(tasks) : [];
}

// Function to create a new list item
function createListItem(task) {
    var li = document.createElement("li");
    var textNode = document.createTextNode(task.text);
    li.appendChild(textNode);
    li.dataset.id = task.id;

    var closeButton = document.createElement('span');
    closeButton.className = 'close-button';
    closeButton.innerHTML = '&times;';
    closeButton.addEventListener('click', function(event) {
        event.stopPropagation();
        removeTask(task.id);
    });
    li.appendChild(closeButton);

    return li;
}

// Function to add a new task
function newElement() {
    var inputValue = document.getElementById("task").value.trim();
    if (inputValue === '') {
        showToast('error');
    } else {
        const tasks = getTasks();
        const newTask = {
            id: Date.now(),
            text: inputValue,
            checked: false
        };
        tasks.push(newTask);
        saveTasks(tasks);

        var li = createListItem(newTask);
        document.getElementById("list").appendChild(li);
        showToast('success');
        document.getElementById("task").value = '';
    }
}

// Function to remove a task
function removeTask(taskId) {
    let tasks = getTasks();
    tasks = tasks.filter(task => task.id !== taskId);
    saveTasks(tasks);
    renderTasks();
}

// Function to toggle checked state of a task
function toggleChecked(event) {
    var listItem = event.target;
    if (listItem.tagName === 'LI') {
        const tasks = getTasks();
        const task = tasks.find(task => task.id == listItem.dataset.id);
        if (task) {
            task.checked = !task.checked;
            saveTasks(tasks);
            listItem.classList.toggle('checked');
        }
    }
}

// Function to render tasks from localStorage
function renderTasks() {
    const tasks = getTasks();
    const list = document.getElementById('list');
    list.innerHTML = '';
    tasks.forEach(task => {
        var li = createListItem(task);
        if (task.checked) {
            li.classList.add('checked');
        }
        list.appendChild(li);
    });
}

// Initial render of predefined tasks
function initializePredefinedTasks() {
    const predefinedTasks = [
        { id: Date.now() + 1, text: '3 Litre Su İç', checked: false },
        { id: Date.now() + 2, text: 'Ödevleri Yap', checked: false },
        { id: Date.now() + 3, text: 'En Az 3 Saat Kodlama Yap', checked: false },
        { id: Date.now() + 4, text: 'Yemek Yap', checked: false },
        { id: Date.now() + 5, text: '50 Sayfa Kitap Oku', checked: false },
    ];
    saveTasks(predefinedTasks);
    renderTasks();
}

document.getElementById('list').addEventListener('click', toggleChecked);
document.addEventListener('DOMContentLoaded', function() {
    if (getTasks().length === 0) {
        initializePredefinedTasks();
    } else {
        renderTasks();
    }
});

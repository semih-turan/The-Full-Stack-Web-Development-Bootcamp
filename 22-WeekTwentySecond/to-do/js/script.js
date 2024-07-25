function newElement() {
    var inputValue = document.getElementById("task").value;

    if (inputValue === '') {
        $(".error").toast("show");
    } else {
        var li = document.createElement("li");
        var textNode = document.createTextNode(inputValue);
        li.appendChild(textNode);
        document.getElementById("list").appendChild(li);
        $(".success").toast("show");
        document.getElementById("task").value = '';
    }
}

function toggleChecked(event) {
    var listItem = event.target;

    if (listItem.tagName === 'LI') {
        var isAlreadyChecked = listItem.classList.contains('checked');

        if (isAlreadyChecked) {
            listItem.classList.remove('checked');
            // Remove the close button if it exists
            var closeButton = listItem.querySelector('.closeButton');
            if (closeButton) {
                closeButton.remove();
            }
        } else {
            listItem.classList.add('checked');
            // Add a close button if it doesn't exist
            if (!listItem.querySelector('.closeButton')) {
                var closeButton = document.createElement('span');
                closeButton.className = 'closeButton';
                closeButton.innerHTML = 'x';
                closeButton.addEventListener('click', function() {
                    // Handle close button click event if needed
                    listItem.remove();x
                });
                listItem.appendChild(closeButton);
            }
        }
    }
}
document.getElementById('list').addEventListener('click', toggleChecked);

var listItems = document.querySelectorAll('#list li');
    listItems.forEach(function(item) {
      var closeButton = document.createElement('button');
      closeButton.innerHTML = '&times;';
      closeButton.className = 'close-button';
      closeButton.addEventListener('click', deleteListItem);
      item.appendChild(closeButton);
    });
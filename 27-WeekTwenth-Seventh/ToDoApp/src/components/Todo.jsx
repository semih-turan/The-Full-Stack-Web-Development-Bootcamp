function Todo({ selectedTodo, setTodoList, todoList }) {

    function handleToggle() {
        setTodoList(todoList.map(todo => {
            if (todo.id === selectedTodo.id) {
                return { ...todo, completed: true };
            }
            return todo;
        }));
    }

    function handleDelete() {
        let filteredTodo = todoList.filter((todo) => todo.id !== selectedTodo.id);
        setTodoList(filteredTodo);
    }

    return (
        <li className={selectedTodo.completed ? "completed" : ""}>
            <div className="view">
                <input className="toggle" type="checkbox" onChange={handleToggle} />
                <label>{selectedTodo.text}</label>
                <button onClick={handleDelete} className="destroy"></button>
            </div>
        </li>
    );
}

export default Todo;
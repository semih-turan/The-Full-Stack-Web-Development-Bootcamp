import React, { useState } from "react";
import Todo from "./components/Todo";
import "./App.css";


function App() {
  const [text, setText] = useState("");
  const [todoList, setTodoList] = useState([]);
  const [filter, setFilter] = useState('all');

  const handleChange = (e1) => {
    setText(e1.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const addTodo = {
      id: Date.now(),
      text: text,
      completed: false
    };
    setTodoList([...todoList, addTodo])
    setText(""); // Yeni bir todo eklerken önceki inputun valuesunda kalmasının önüne geçmek için
  };

  const filteredTodoList = todoList.filter(todo => {
    if (filter === 'all') {
      return true;
    } else if (filter === 'active') {
      return !todo.completed;
    } else if (filter === 'completed') {
      return todo.completed;
    }
  });

  function clearCompleted() {
    let filteredTodo = todoList.filter((todo) => todo.completed !== true);
    setTodoList(filteredTodo);
  }


  return (
    <>
      <section className="todoapp">
        <header className="header">
          <h1>todos</h1>
          <form className="inputForm" onSubmit={handleSubmit}>
            <input
              className="new-todo"
              placeholder="What needs to be done?"
              autoFocus
              value={text}
              onChange={handleChange}
            />
          </form>
        </header>

        <section className="main">
          <input className="toggle-all" type="checkbox" />
          <label htmlFor="toggle-all">Mark all as complete</label>
          <ul className="todo-list">
            {filteredTodoList.map(todo => (
              <Todo
                key={todo.id}
                selectedTodo={todo}
                setTodoList={setTodoList}
                todoList={todoList}
              />
            ))}
          </ul>
        </section>

        <footer className="footer">
          <span className="todo-count">
            <strong>{todoList.length} </strong>
            items left
          </span>

          <ul className="filters">
            <li>
              <a href="#/" onClick={() => setFilter('all')}>
                All
              </a>
            </li>
            <li>
              <a href="#/" onClick={() => setFilter('active')}>
                Active
              </a>
            </li>
            <li>
              <a href="#/" onClick={() => setFilter('completed')}>
                Completed
              </a>
            </li>
          </ul>

          <button className="clear-completed" onClick={clearCompleted}>Clear completed</button>
        </footer>
      </section>
    </>
  );
}

export default App;
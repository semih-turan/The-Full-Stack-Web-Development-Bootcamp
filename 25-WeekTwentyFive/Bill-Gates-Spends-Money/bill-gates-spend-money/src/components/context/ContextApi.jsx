import React, { createContext, useState } from 'react';
import { DATA } from '../item';
// Create Context
export const Context = createContext();
export const initMoney = 100000000000;
export const showReceipt = (money) => {
  var element = document.getElementById("receipt");

  if(money < 100000000000){
    element.classList.remove("toggle");
  }else if(money === 100000000000){
    element.classList.add("toggle");
  }
  
};

// Create Context Provider
export const Provider = (props) => {
  
  const [money, setMoney] = useState(initMoney);
  const [data, setData] = useState(DATA);
  const [items, setItems] = useState(DATA.map((product, index) =>{
    return {...product, quantity:0, id:index}
  }));
 
console.log(items);
  return (
    <Context.Provider value={
      { money,
       setMoney,
       data,
       setData,
       items,
       setItems
    }}>
      {props.children}
    </Context.Provider>
  );
};
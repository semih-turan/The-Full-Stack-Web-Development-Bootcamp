import React, { useState, useContext } from "react";
import { Context } from '../context/ContextApi';
import './receipt.css'

function Receipt() {

  const formatter = Intl.NumberFormat('en', { notation: 'compact'});

  const { items } = useContext(Context);

  const totalCost = items.reduce((total, item) => total + item.item_cost * item.quantity, 0);

  return (
    <div className="receipt-wrapper, toggle" id="receipt">
      <div className="receipt-header"><h1>Your Receipt</h1></div>
      <div className="receipt-items-wrapper">
    {items.filter(item => item.quantity>0)
    .map((item, index) => (
        <div id="selam" className="receipt-item" key={index}>
          <div className="receipt-item-name">{item.item_name}</div>
          <div className="receipt-item-quantity">x{item.quantity}</div>
          <div className="receipt-item-total">{formatter.format(item.item_cost * item.quantity)}$</div>
        </div>
    ))}
    
    <p className="total-cost">Total cost: <span>{totalCost.toLocaleString()}$</span></p>
      </div>
    </div>
  )
}

export default Receipt


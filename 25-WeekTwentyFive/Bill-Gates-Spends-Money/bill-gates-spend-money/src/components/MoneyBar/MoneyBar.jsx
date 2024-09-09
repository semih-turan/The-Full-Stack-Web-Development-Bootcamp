import React, { useState, useContext } from 'react';
import { Context } from '../context/ContextApi';
import './money-bar.css'

function MoneyBar(){
    const { money, setMoney } = useContext(Context);
    return <div className='money-bar'>{money.toLocaleString()}$</div>;
}

export default MoneyBar
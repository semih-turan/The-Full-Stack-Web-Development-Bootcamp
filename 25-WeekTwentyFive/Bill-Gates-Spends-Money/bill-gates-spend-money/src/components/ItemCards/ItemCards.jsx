import React, { useState, useContext, useEffect } from "react";
import { Context, initMoney, showReceipt } from "../context/ContextApi";
import './item-cards.css'


function Card({item, index }){
    const { money, setMoney } = useContext(Context);
    const { items, setItems } = useContext(Context);
    const [count, setCount] = useState(0);
    
    const itemPrice = + item.item_cost;

    const removeItem = ()=> {
        
        setCount(count - 1);
        setMoney(money + itemPrice);
        setItems(prevItems => {
            const existingItemIndex = prevItems.findIndex(i => i.id === item.id);
            if (existingItemIndex !== -1) {
                // Eğer öğe varsa, miktarını artırıyoruz
                const newItems = [...prevItems];
                newItems[existingItemIndex] = {...newItems[existingItemIndex], quantity: count - 1};
                return newItems;
            } else {
                // Eğer öğe yoksa, yeni bir öğe ekliyoruz
                return [...prevItems, {...item, quantity: 1}];
            }
        });
    
    }

    const buyItem = ()=> {
        if(money > 0 && itemPrice <= money){
        setCount(count + 1);
        setMoney(money - itemPrice);
        setItems(prevItems => {
            const existingItemIndex = prevItems.findIndex(i => i.id === item.id);
            if (existingItemIndex !== -1) {
                // Eğer öğe varsa, miktarını artırıyoruz

                const newItems = [...prevItems];
                newItems[existingItemIndex] = {...newItems[existingItemIndex], quantity: count + 1};
                return newItems;
            } else {
                // Eğer öğe yoksa, yeni bir öğe ekliyoruz
                return [...prevItems, {...item, quantity: 1}];
                
            }
        });
        }
    }

    const handleClick = (e) =>{
        if(e.target.classList.contains("btn-sell")){
            if (count > 0){
                removeItem();
                
            }
            return
        } else {
            buyItem();
            
        }
    }

    useEffect(() => {
        showReceipt(money);
    }, [money]);

    return(
        
        <div className="card-container">
                <div className="card">
                    <div className="item-img-wrapper"><img src={item.img_src} alt="" />
                    </div>
                    <div className="item-name">{item.item_name}</div>
                    <div className="item-price">{item.item_cost.toLocaleString()}</div>
                    <div className="item-buttons">
                        <button className="btn-sell" type="button" onClick={handleClick}>Sell</button>
                        <input className="item-counter" type="number" value={count} readOnly />
                        <button className="btn-buy" type="button" onClick={handleClick}>Buy</button>
                    </div>
                </div>
        </div>
        
    )
}

export default Card
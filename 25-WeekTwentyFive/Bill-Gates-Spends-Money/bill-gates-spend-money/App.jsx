import React, { useContext } from 'react';
import { Context } from './src//components/context/ContextApi';
import Header from './src/components/Header/Header';
import MoneyBar from './src/components/MoneyBar/MoneyBar';
import Card from './src/components/ItemCards/ItemCards';
import './app.css'
import Receipt from './src/components/Receipt/Receipt';

function App() {
    
    const { items, setItems } = useContext(Context);
    
    return (
        
        <div className='wrapper'>
            <Header />
            <MoneyBar />
            <div className='card-list'>
            {items.map((item, index) =>
                <Card item={item} key={index} />
            )}
           </div>
           <Receipt />
        </div>
        
    );
}

export default App;

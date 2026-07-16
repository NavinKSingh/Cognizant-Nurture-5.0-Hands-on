import React from 'react';

// Attribute value used to display the image of the office space
const officeImage =
    'https://images.unsplash.com/photo-1497366216548-37526070297c?w=400';

// An object of office to display details like Name, Rent and Address
const office = {
    name: 'Prestige Business Park',
    rent: 55000,
    address: 'MG Road, Bengaluru'
};

// A list of office objects to loop through and display more data
const officeList = [
    { name: 'Prestige Business Park', rent: 55000, address: 'MG Road, Bengaluru' },
    { name: 'DLF Cyber City', rent: 75000, address: 'Gurugram, Haryana' },
    { name: 'RMZ Ecoworld', rent: 62000, address: 'Bellandur, Bengaluru' },
    { name: 'One BKC', rent: 95000, address: 'Bandra Kurla Complex, Mumbai' },
    { name: 'Tidel Park', rent: 48000, address: 'Taramani, Chennai' }
];

function App() {
    // JavaScript expression used inside JSX
    const heading = 'Office Space Rental';

    return (
        <div>
            {/* Element to display the heading of the page */}
            <h1>{heading}</h1>

            {/* Attribute (src) to display the image of the office space */}
            <img src={officeImage} alt="Office Space" width="300" />

            <h2>Featured Office</h2>
            <p>Name: {office.name}</p>
            <p>Address: {office.address}</p>
            {/* Inline CSS in JSX: red if rent < 60000, green otherwise */}
            <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
                Rent: {office.rent}
            </p>

            <h2>All Available Office Spaces</h2>
            <ul>
                {officeList.map((item, index) => (
                    <li key={index}>
                        <p>Name: {item.name}</p>
                        <p>Address: {item.address}</p>
                        <p style={{ color: item.rent < 60000 ? 'red' : 'green' }}>
                            Rent: {item.rent}
                        </p>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;

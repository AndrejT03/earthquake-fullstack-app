import React from 'react';
import { fetchEarthquakes } from '../services/earthquakeService.js';

const FetchButton = ({ onFetch }) => {

    const handleClick = async () => {
        await fetchEarthquakes();
        onFetch();
    };

    return (
        <button className="btn btn-primary mt-2 mb-3" onClick={handleClick}>
            Fetch Latest Earthquakes
        </button>
    );
};
export default FetchButton;
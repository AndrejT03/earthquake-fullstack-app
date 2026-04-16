import React, { useEffect, useState } from 'react';
import { getEarthquakes, deleteEarthquake } from '../services/earthquakeService.js';

const EarthquakeTable = () => {

    const [earthquakes, setEarthquakes] = useState([]);

    const loadData = async () => {
        const eq = await getEarthquakes();
        setEarthquakes(eq.data);
    };

    const handleDelete = async (id) => {
        await deleteEarthquake(id);
        loadData();
    };

    useEffect(() => {
        loadData();
    }, []);

    return (
        <div>
            <h2 className="mt-2">Earthquake Data</h2>
            <table className="table table-striped mt-3">
                <thead>
                <tr>
                    <th>Magnitude</th>
                    <th>Place</th>
                    <th>Title</th>
                    <th>Time</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {earthquakes.map(eq => (
                    <tr key={eq.id}>
                        <td>{eq.magnitude}</td>
                        <td>{eq.place}</td>
                        <td>{eq.title}</td>
                        <td>{new Date(eq.time).toLocaleString()}</td>
                        <td>
                            <button
                                className="btn btn-danger"
                                onClick={() => handleDelete(eq.id)}
                            >
                                Delete
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};
export default EarthquakeTable;
import axios from "axios";

const baseUrl = "http://localhost:8080/api/earthquakes";

export const fetchEarthquakes = () => {
    return axios.get(`${baseUrl}/fetch`);
};

export const getEarthquakes = () => {
    return axios.get(baseUrl);
};

export const deleteEarthquake = (id) => {
    return axios.delete(`${baseUrl}/${id}`);
};
import { useState } from 'react'
import "bootstrap/dist/css/bootstrap.min.css";
import EarthquakeTable from "./components/EarthquakeTable";
import FetchButton from "./components/FetchButton";

function App() {
  const reloadPage = () => {
    window.location.reload();
  };

  return (
      <div className="container mt-5">
        <h1>Earthquake Monitoring App</h1>

        <FetchButton onFetch={reloadPage} />

        <EarthquakeTable />
      </div>
  );
};

export default App;
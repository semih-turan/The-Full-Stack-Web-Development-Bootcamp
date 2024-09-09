import React from 'react';
import { useParams } from 'react-router-dom';

const StarshipDetail = ({ starships }) => {
  const { starshipName } = useParams();
  const starship = starships.find(starship => starship.name === starshipName);

  if (!starship) {
    return <div>Starship not found</div>;
  }

  return (
    <div>
      <h2>{starship.name} Details</h2>
      <div><strong>Name:</strong> {starship.name}</div>
      <div><strong>Model:</strong> {starship.model}</div>
      <div><strong>Number of Passengers:</strong> {starship.passengers}</div>
      <div><strong>Max Atmospheric Speed:</strong> {starship.max_atmosphering_speed}</div>
      <div><strong>Manufacturer:</strong> {starship.manufacturer}</div>
      <div><strong>Crew:</strong> {starship.crew}</div>
      <div><strong>Cargo Capacity:</strong> {starship.cargo_capacity}</div>
    </div>
  );
};

export default StarshipDetail;
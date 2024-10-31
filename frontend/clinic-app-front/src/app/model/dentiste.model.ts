import {User} from "./user.model.js";


export interface Salle {
  salleId: number;
  nom: string;
}

export interface Dentiste {
  dentisteId: number;
  prenom: string;
  specialite: string;
  telephone: string;
  user: User;
  salle: Salle;
}

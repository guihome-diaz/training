import {Address} from "./address";

export class Contact {

  constructor() {
    this.address = new Address();
  }


  id: string;
  firstName: string;
  lastName: string;
  profession: string;
  socialSecurityNumber: string;
  birthDate: string;
  birthPlace: string;
  address: Address;
}

export class Room {
    constructor(
        public roomId: number,
        public roomRent: number,
        public roomType: string,
        public roomCapacity: number,
        public roomStatus: string,
        public hotelId: number,
        public imgURL: string
    ) { }
}

export class Employee {
    constructor(
        public empId: number,
        public name: string,
        public email: string,
        public phone: number,
        public status: string,
        public pk ?: string
    ) {}
}

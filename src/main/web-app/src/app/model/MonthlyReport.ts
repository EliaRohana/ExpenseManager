/**
 * Created by 310256861 on 09/01/2017.
 */
export class MonthlyReport{

    private _id:     number;
    private _name:   string;
    private _month:  string;
    private _year:   number;
    private _userId: number;


    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get name(): string {
        return this._name;
    }

    set name(value: string) {
        this._name = value;
    }

    get month(): string {
        return this._month;
    }

    set month(value: string) {
        this._month = value;
    }

    get year(): number {
        return this._year;
    }

    set year(value: number) {
        this._year = value;
    }

    get userId(): number {
        return this._userId;
    }

    set userId(value: number) {
        this._userId = value;
    }
}
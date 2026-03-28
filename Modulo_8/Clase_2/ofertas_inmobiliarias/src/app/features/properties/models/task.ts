export interface Task{
    id: number;
    name: string;
    date_start: Date;
    date_finish: Date;
    date_complete: Date;
    // time: Date, esto deberia ser date_finish - date_start
    responsible: string; 
    state: string
}
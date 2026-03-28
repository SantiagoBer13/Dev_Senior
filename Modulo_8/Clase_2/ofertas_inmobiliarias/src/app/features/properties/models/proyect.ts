import { Task } from "./task";

export interface Project{
    id: number;
    name: string;
    description: string;
    imageUrl: string;
    date_start: Date;
    date_estimated: Date;
    date_finish: Date;
    manager: string;
    tasks: Array<Task>;
}
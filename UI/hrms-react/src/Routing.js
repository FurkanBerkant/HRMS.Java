import JobPostings from "./pages/JobPostings";
import JobTitles from "./pages/JobTitles";
import Employee from "./pages/users/Employee";
import Employer from "./pages/users/Employer";
import JobSeeker from "./pages/users/JobSeeker";
import Resumes from "./pages/Resumes";
import Dashboard from "./layouts/Dashboard";

export const routes = [

    {
        path: "/",
        exact: true,
        component: <Dashboard />,
        title: "Anasayfa",
        isHeaderElement: true,
    },
    {
        path: "/employer",
        exact: true,
        component: <Employer />,
        title: "Employer",
        isHeaderElement: true,
    },
    {
        path: "/jobSeeker",
        exact: true,
        component: <JobSeeker />,
        title: "JobSeeker",
        isHeaderElement: true,
    },
    {
        path: "/employee",
        exact: true,
        component: <Employee />,
        title: "Employee",
        isHeaderElement: true,
    },
    {
        path: "/jobPosting",
        exact: true,
        component: <JobPostings />,
        title: "JobPostings",
        isHeaderElement: true,
    },
    {
        path: "/jobTitle",
        exact: true,
        component: <JobTitles />,
        title: "JobTitle",
        isHeaderElement: true,
    },
    {
        path: "/resume",
        exact: true,
        component: <Resumes />,
        title: "Resume",
        isHeaderElement: true,
    }
];
'''
Build a console application for School Management System.
Functional Requirements: 3 Actors: Instructors, Students and Admin. Instructors and Students are represented by a unique ID.

Solution

1. Instructors can offer new courses to be taught for a particular class. Each course has a start and end date.
2. Instructors can submit grades for students for the courses taught by them.
3. Instructors can view the information of students that are taking a particular course offered by them.
4. Instructors may offer multiple courses at the same time.
1. Students can register for any offered courses for which they are eligible.
2. Students can drop out of the course until the mid-point of the course duration
3. Students can check their grades for the courses they are registered for.
1. Admin can register students and instructors into the system.

* Accessibility mode
Settings
For the sake of simplicity, assume that there is no authentication involved. It is safe to store all data in-memory, no need of writing to a file or storing stuff in a database

Expectation:
1. The code should be functionally correct and complete.
2. Exception handling should be done properly.
3. The code should not be a monolith. It should be possible to extend functionality for your code without making a ton of changes.
4. The code should follow the basic principles of OOP.
5. Use meaningful names for variables and data objects as much as possible.
'''

from ABC import abc

class RoleType:
    Student
    Teacher

# {"AnkurID": {"CSE01": 8.0, "CSE02": 9.0,}}

class MarksMap:

    self.markmap = dict(dict())

    def __init__(self, studObj, courseObj, marks):
        temp = {courseID: "", coursemarks: 0.0}
        self.markmap[studObj.id] = {courseObj.id: self.marks}

    def serachCourseMarks(self, studObj, courseObj):
        
        if studObj.id in self.markmap:

            if courseObj.id in self.markmap[studObj.id]:

                return self.markmap[studObj.id][courseObj.id]

            else:
                return -1

        else:
            return -1.0

class StudentCourseMap:

    self.courseMap = dict(list)

    def __init__(self, courseObj, studentObj):
        self.courseMap[courseObj.id].append(studentObj.id)

    def getCourse(self, courseId):
        return self.courseMap.get(id, -1)

class Course:

    self.course = dict()

    def __init__(self, id, coursename, startTime, endTime, insutructorObj):
        self.id = random(1, 10000) if id is None else id
        self.coursename = coursename
        self.startTime = startTime
        self.endTime = endTime
        self.insutructor = insutructorObj

    def registerCourse(self, courseObj):
        if self.coursename in  self.course:
            return
        self.course[self.coursename] = courseObj

    def searchCourse(self, courseName):

        if Coursename in self.course:
            return self.course[self.coursename]

        return -1

class Instructor:

    self.teacher = dict()

    def __init__(self, Tid, Tname):
        self.Tid = Tid
        self.Tname = Tname

    def registerTeacher(self, obj):
        self.teacher[self.Tid] = obj

    def searchTeacher(self, teacherName):

        if teachername in self.teacher:
            return self.teacher[self.Tid]
        return -1

    @staticmethod
    def createCourse(self, coursename, startTime, endTime):

        if coursename in Course.course:
            return "Alread created"
        
        csObj = Course(coursename, startTime, endTime, self)
        return csObj

    def caclMarks(self, courseObj, studObj):



class Students:

    self.students = dict()

    def __init__(self, Sid, Tname):
        self.Sid = Sid
        self.Tname = Tname

    def registerTeacher(self, Tid):
        self.students[Tid] = obj

    def searchstudents(self, studentsName):

        if studentsname in self.students:
            return self.students[self.Tid]
        return -1

    def assignCourse(self, courseObj):
        if self.Sid in StudentCourseMap.courseMap[courseObj]:
            return "Already there"

        StudentCourseMap.courseMap[courseObj.id] = self
        return "Added!!"

    

class AdminRoleClass(abc):
    
    def Teacher():
        pass

    def Student():
        pass


class Admin:

    def __init__(self, roleType, id, name):
        self.role = roleType

        if self.self.role = RoleType.Student:
            Students(id, name)
        else:
            Instructor(id, name)


# TODO
CourseObj = Course()

            



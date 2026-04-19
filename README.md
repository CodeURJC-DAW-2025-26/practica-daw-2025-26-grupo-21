# La Phonoteka

## Team Members

| Name | Surname | Email | GitHub |
| ------ | --------- | ------ | ------- |
| Adrián | Morales | a.morales.2019@alumnos.urjc.es | Adri-md-1208 |

# Preparation 1: Project Definition

## Project Overview
La Phonoteka is an online platform dedicated to the buying and selling of vinyl records. It allows users to register, list vinyl records for sale, make purchases, and rate other users.

## Entities

### User
Represents a registered person on the platform.

### Vinyl
Represents an item that can be bought or sold on the platform.

### Transaction
Represents a buying or selling action of a Vinyl entity.

### Rating
Represents a review/rating given by a User to another User after a Transaction has taken place between them.

The relationship exists because a User makes a Transaction for a Vinyl and can receive/give a Rating.

![ER Diagram](assets/diagrams/ERD.svg)

## User Permissions

| Feature | Anonymous | Registered | Administrator | Description |
| :--- | :---: | :---: | :---: | :--- |
| **View vinyl records** | Yes | Yes | Yes | Everyone can see the available vinyl records. |
| **Search vinyl records** | Yes | Yes | Yes | Search by artist, title, genre, etc. |
| **View vinyl details** | Yes | Yes | Yes | Access to the complete information of a vinyl record. |
| **Register** | Yes | No | No | Only anonymous users can register. |
| **Log in** | Yes | No | No | Only anonymous users can log in. |
| **Log out** | No | Yes | Yes | |
| **List vinyl for sale** | No | Yes | Yes | A registered user can put their vinyl records up for sale. |
| **Edit/Delete own vinyl** | No | Yes | Yes | Only the owner of the vinyl or an administrator can edit/delete it. |
| **Buy a vinyl** | No | Yes | Yes | Registered users can make purchases. |
| **View purchase/sale history** | No | Yes | Yes | Each user sees their own history. |
| **Leave a rating** | No | Yes | Yes | Rate transactions or other users. |
| **Modify own profile** | No | Yes | Yes | Change personal data, avatar, etc. |
| **Manage all vinyl records** | No | No | Yes | Full CRUD on all vinyl records on the platform. |
| **Manage all users** | No | No | Yes | Full CRUD on all users on the platform. |
| **View platform statistics** | No | No | Yes | Access to the system's charts and metrics. |

## Images

The application contains several types of images:

- **Profile picture**: Optional photo that can be uploaded when creating or modifying a profile. 1 user has 0 or 1 photos.
- **Vinyl picture**: Mandatory photo of the vinyl the user is going to sell. 1 Vinyl has 1 photo.

## Charts

The application will offer charts to administrators so they can have a general overview of the platform's status:

- **Sales over time** (line chart)
- **New user registrations** (line chart)
- **Vinyl distribution based on attributes** (pie chart)
- **Top selling and top buying users** (ranking chart)

## Complementary Technology
Automated email sending to notify users when their vinyl has been sold or when they have received a comment/rating.

## Advanced Algorithm or Query
Vinyl recommendations for registered users while they are viewing a vinyl record. They will appear at the bottom of the page. Recommendations will be based on the attributes of the vinyl records they have already purchased.

# Preparation 2: Layout of pages with HTML and CSS

## Navigation diagram
Red: admin
Green: Anonymous
Blue: Registered

![Navigation Diagram](assets/diagrams/navigation.png)

## Anonymous user pages

### View/Search vinyls
Anon user can view and search vinyls in the main page.
![Index](assets/screenshots/anonymous/index.png)

### View vinyl details
Anon user can view the details of a vinyl.
![View Vinyl Details](assets/screenshots/anonymous/vinyl.png)

### Register
Anon user can be registered.
![Register](assets/screenshots/anonymous/register.png)

### Login
Anon user can log in.
![Login](assets/screenshots/anonymous/login.png)

## Registered user pages

### View/Search vinyls
Registered user can view and search vinyls in the main page.
![Index](assets/screenshots/registered/index.png)

### View vinyl details
Registered user can view the details of a vinyl.
![View Vinyl Details](assets/screenshots/registered/vinyl.png)

### List vinyl for sale
Registered user can list vinyls for sale.
![List Vinyl for Sale](assets/screenshots/registered/list-new-vinyl.png)

### Logout
Registered user can log out.
![Logout](assets/screenshots/registered/logout.png)

### Edit own vinyls
Registered user can edit his own vinyls in sale.
![Edit Vinyl](assets/screenshots/registered/manage-vinyls.png)

### Buy vinyl
Registered user can buy vinyls.
![Buy Vinyl](assets/screenshots/registered/cart.png)

### View purchase history
Registered user can see his purchase history.
![View Purchase History](assets/screenshots/registered/purchase-history.png)

### Leave a rating
Registered user can leave ratings in his purchases.
![Leave a Rating](assets/screenshots/registered/rating.png)

### Modify own profile
Registered user can modify his own profile.
![Modify Profile](assets/screenshots/registered/edit-profile.png)

## Admin pages

### View/Search vinyls
Admin can view and search vinyls.
![Index](assets/screenshots/admin/index.png)

### View vinyl details
Admin can view the details of a vinyl.
![View Vinyl Details](assets/screenshots/admin/vinyl.png)

### List vinyl for sale
Admin can list vinyls for sale.
![List Vinyl for Sale](assets/screenshots/admin/list-new-vinyl.png)

### Logout
Admin can log out.
![Logout](assets/screenshots/admin/logout.png)

### Edit own vinyls
Admin can edit his own vinyls.
![Edit Vinyl](assets/screenshots/admin/manage-vinyls.png)

### Buy new vinyl
Admin can buy new vinyls.
![Buy Vinyl](assets/screenshots/admin/cart.png)

### View purchase history
Admin can see the purchase history.
![View Purchase History](assets/screenshots/admin/purchase-history.png)

### Leave a rating
Admin can leave ratings.
![Leave a Rating](assets/screenshots/admin/rating.png)

### Modify own profile
Admin can modify his own profile.
![Modify Profile](assets/screenshots/admin/edit-profile.png)

### Manage all users
Admin can manage the users of the app.
![Admin User Management](assets/screenshots/admin/admin-users.png)

### Manage all vinyls
Admin can manage the vinyls of the app.
![Admin Vinyl Management](assets/screenshots/admin/admin-vinyls.png)

### View platform statistics
Admin can view app statistics.
![Platform Statistics](assets/screenshots/admin/dashboard.png)
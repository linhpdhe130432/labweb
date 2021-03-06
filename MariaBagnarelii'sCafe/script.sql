USE [master]
GO
/****** Object:  Database [MariaCafe]    Script Date: 3/11/2020 3:53:08 PM ******/
CREATE DATABASE [MariaCafe]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MariaCafe', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\MariaCafe.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MariaCafe_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\MariaCafe_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [MariaCafe] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MariaCafe].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MariaCafe] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MariaCafe] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MariaCafe] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MariaCafe] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MariaCafe] SET ARITHABORT OFF 
GO
ALTER DATABASE [MariaCafe] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MariaCafe] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [MariaCafe] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MariaCafe] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MariaCafe] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MariaCafe] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MariaCafe] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MariaCafe] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MariaCafe] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MariaCafe] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MariaCafe] SET  DISABLE_BROKER 
GO
ALTER DATABASE [MariaCafe] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MariaCafe] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MariaCafe] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MariaCafe] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MariaCafe] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MariaCafe] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MariaCafe] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MariaCafe] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [MariaCafe] SET  MULTI_USER 
GO
ALTER DATABASE [MariaCafe] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MariaCafe] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MariaCafe] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MariaCafe] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [MariaCafe]
GO
/****** Object:  Table [dbo].[Cake]    Script Date: 3/11/2020 3:53:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cake](
	[id] [int] NULL,
	[name] [nvarchar](150) NULL,
	[fullContent] [nvarchar](max) NULL,
	[shortContent] [nvarchar](max) NULL,
	[createdDate] [date] NULL,
	[price] [float] NULL,
	[img] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Contact]    Script Date: 3/11/2020 3:53:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[id] [int] NULL,
	[name] [nvarchar](150) NULL,
	[address] [nvarchar](max) NULL,
	[phone] [nvarchar](20) NULL,
	[email] [nvarchar](50) NULL,
	[openingHours] [nvarchar](max) NULL,
	[isOnHomePage] [bit] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Introduction]    Script Date: 3/11/2020 3:53:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Introduction](
	[id] [int] NULL,
	[title] [nvarchar](150) NULL,
	[content] [nvarchar](max) NULL,
	[img] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
INSERT [dbo].[Cake] ([id], [name], [fullContent], [shortContent], [createdDate], [price], [img]) VALUES (1, N'In the Afternoon', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. <br> Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.', CAST(N'2020-01-01' AS Date), 15, N'i282319414620354139._rsw480h360_szw480h360_.jpg')
INSERT [dbo].[Cake] ([id], [name], [fullContent], [shortContent], [createdDate], [price], [img]) VALUES (2, N'Traditional Cakes', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. <br> Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.', CAST(N'2020-02-02' AS Date), 20, N'i282319414620354374._rsw480h360_szw480h360_.jpg')
INSERT [dbo].[Cake] ([id], [name], [fullContent], [shortContent], [createdDate], [price], [img]) VALUES (3, N'alo', N'alo123', N'alo123', CAST(N'2020-03-03' AS Date), 25, N'i282319414620354374._rsw480h360_szw480h360_.jpg')
INSERT [dbo].[Cake] ([id], [name], [fullContent], [shortContent], [createdDate], [price], [img]) VALUES (4, N'Minh', N'Minhhhhhh', N'Minhhhhhhhhhhh', CAST(N'2020-04-04' AS Date), 30, N'i282319414620354374._rsw480h360_szw480h360_.jpg')
INSERT [dbo].[Cake] ([id], [name], [fullContent], [shortContent], [createdDate], [price], [img]) VALUES (5, N'Cakeeeeeee', N'Cakeeeeee', N'Cakeeeeeeeeee', CAST(N'2020-05-05' AS Date), 35, N'i282319414620354374._rsw480h360_szw480h360_.jpg')
INSERT [dbo].[Contact] ([id], [name], [address], [phone], [email], [openingHours], [isOnHomePage]) VALUES (1, N'Lorem ipsum dolor sit amet, consectetuer adipiscing elitLorem ipsum dolor sit amet, consectetuer adipiscing elit', N'Gammel Torv, Copenhagen', N'12 1234 1234', NULL, N'Monday: Closed<br>Tuesday - Friday: 10:00 - 20:00<br>Saturday and Sunday: 11.00 - 21:00', 1)
INSERT [dbo].[Contact] ([id], [name], [address], [phone], [email], [openingHours], [isOnHomePage]) VALUES (2, N'Lorem ipsum dolor sit amet, consectetuer adipiscing elitLorem ipsum dolor sit amet, consectetuer adipiscing elit', N'Copenhagen, Denmark', N'123456', N'your-email@your-email.com', N'Monday: Closed<br>Tuesday - Friday: 10:00 - 20:00<br>Saturday and Sunday: 11.00 - 21:00', 0)
INSERT [dbo].[Introduction] ([id], [title], [content], [img]) VALUES (1, N'Maria''s Cosy Cafe', N'<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
                                                laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p><br>Claritas est etiam processus dynamicus, qui sequitur
 mutationem consuetudium lectorum. Mirum est notare quam littera gothica', N'i282319414584937113._szw480h1280_.jpg')
USE [master]
GO
ALTER DATABASE [MariaCafe] SET  READ_WRITE 
GO
